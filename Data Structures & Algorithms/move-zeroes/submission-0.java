class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for(int right = 0;right < nums.length;right++) {
            if(nums[right] != 0) {
                swap(nums, right, left);
                left++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}