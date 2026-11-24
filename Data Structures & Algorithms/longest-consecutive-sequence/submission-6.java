class Solution {
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int ele: nums) {
            set.add(ele);
        }

        int maxLen = 0;
        int count = 0;
        Integer prev = null;

        for(int ele: set) {
            if(prev != null && prev + 1 == ele) {
                count++;
            } else {
                count = 1;
            }
            maxLen = Math.max(maxLen, count);
            prev = ele;
        }

        return maxLen;
    }
}
