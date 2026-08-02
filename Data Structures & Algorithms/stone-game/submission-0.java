class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n+1][n+1];

        for(int i=0;i<n+1;i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, n-1, piles) > 0;
    }

    public int solve(int start, int end, int[] arr) {
        if(start > end) {
            return 0;
        }

        if(dp[start][end] != -1) {
            return dp[start][end];
        }

        int sum_start = arr[start] - solve(start+1, end, arr);
        int sum_end = arr[end] - solve(start, end-1, arr);

        return dp[start][end] = Math.max(sum_start, sum_end);
    }
}