class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];

        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            ans[left] = nums[left] * nums[left];
            ans[right] = nums[right] * nums[right];
            left++;
            right--;
        }
        Arrays.sort(ans);
        return ans;
    }
}