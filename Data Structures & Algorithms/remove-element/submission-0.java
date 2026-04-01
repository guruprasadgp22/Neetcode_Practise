class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            if(nums[left] == val) {
                swap(left, right, nums);
                right--;
            } else {
                left++;
            }        
        }

        return left;
    }

    public void swap(int left, int right, int[] arr) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}