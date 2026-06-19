class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;

        for(int ele: nums) {
            ans ^= ele;
        }

        return ans;
    }
}