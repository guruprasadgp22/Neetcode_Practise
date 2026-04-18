class Solution {
    public int findLucky(int[] arr) {
        int max = -1;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int ele:arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getKey() == entry.getValue()) {
                max = entry.getKey();
            }
        }

        return max;
    }
}