class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for(int ele: nums) {
            if(seen.contains(ele)) {
                return true;
            }
            seen.add(ele);
        }

        return false;
    }
}