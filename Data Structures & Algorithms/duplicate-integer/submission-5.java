class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            if (map.containsKey(ele)) {
                return true;
            }
            map.put(ele, 1);
        }
        return false;
    }
}