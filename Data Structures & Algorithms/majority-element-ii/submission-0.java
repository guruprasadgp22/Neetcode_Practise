class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        List<Integer> ans = new LinkedList<>();
        int val = nums.length/3;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > val) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }
}