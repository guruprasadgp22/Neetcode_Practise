class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());
        int i=0;
        int[] ans = new int[k];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(i == k) {
                break;
            }

            ans[i] = list.get(i).getKey();
            i++;
        }

        return ans;
    }
}
