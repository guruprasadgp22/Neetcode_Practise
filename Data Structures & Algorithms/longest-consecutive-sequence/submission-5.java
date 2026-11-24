class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums) {
            set.add(ele);
        }

        int maxLen = 0;

        for(int ele: set) {
            if(!set.contains(ele - 1)) {
                int count = 1;
                int x = ele;

                while(set.contains(x+1)) {
                    count++;
                    x = x + 1;
                }

                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}
