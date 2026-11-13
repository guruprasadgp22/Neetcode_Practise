class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++) {
            while(!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }

            int best = dq.isEmpty()? 0: Math.max(0, dp[dq.peekFirst()]);
            dp[i] = nums[i] + best;
            ans = Math.max(ans, dp[i]);

            while(!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        return ans;
    }
}
