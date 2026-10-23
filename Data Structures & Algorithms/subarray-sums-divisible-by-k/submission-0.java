class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int ele: nums) {
            currSum += ele;
            int rem = currSum % k;
            if(map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}