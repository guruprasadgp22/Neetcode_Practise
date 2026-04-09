class Solution {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for(String ele: arr) {
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        int count = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
                count++;
            }

            if(count == k) {
                return entry.getKey();
            }
        }

        return "";
    }
}