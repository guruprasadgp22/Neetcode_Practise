class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1_000_000_007;
        int n = nums.length;

        long[] arr = new long[n];
        arr[0] = 1;

        for(int i=1;i<n;i++) {
            arr[i] = (arr[i-1] * 2) % mod;
        }

        int left = 0;
        int right = n-1;
        long ans = 0;

        while(left <= right) {
            if(nums[left] + nums[right] <= target) {
                ans = (ans +  arr[right-left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return  (int)ans;
    }
}