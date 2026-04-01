class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int element = nums[0];
        for(int ele: nums) {
            if(ele == element) {
                count++;
            } else {
                if(count > 1) {
                    return element;
                }
                element = ele;
                count = 1;
            }
        }

        return element;
    }
}
