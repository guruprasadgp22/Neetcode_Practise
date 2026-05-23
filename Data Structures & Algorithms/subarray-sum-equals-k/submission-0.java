class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        for(int ele: nums) {
            currentSum += ele;

            if(freq.containsKey(currentSum - k)) {
                count += freq.get(currentSum - k);
            }

            freq.put(currentSum, freq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}