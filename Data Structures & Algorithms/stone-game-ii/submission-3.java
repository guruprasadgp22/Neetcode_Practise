class Solution {
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        dp = new int[n+1][2][n+1];
        for(int i=0;i<n+1;i++) {
            Arrays.fill(dp[i][1], -1);
            Arrays.fill(dp[i][0], -1);
        }
        return solve(1, 0, 1, piles);
    }

    private int solve(int person, int index, int M, int[] piles) {
        if(index >= piles.length) {
            return 0;
        }
        if(dp[index][person][M] != -1) {
            return dp[index][person][M];
        }

        int stones = 0;
        int result = (person == 1? Integer.MIN_VALUE: Integer.MAX_VALUE);
        for(int i=1; i <= Math.min(piles.length - index, 2*M); i++) {
            stones += piles[index+i-1];
            if(person == 1) {
                result = Math.max(result, stones + solve(0, index+i, Math.max(M, i), piles));
            } else {
                result = Math.min(result, solve(1, index+i, Math.max(M, i), piles));
            }
        }
        return dp[index][person][M] = result;
    }
}