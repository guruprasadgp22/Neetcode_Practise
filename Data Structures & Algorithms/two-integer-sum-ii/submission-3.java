class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int remaining = target - numbers[i];
            if(map.containsKey(remaining)) {
                return new int[]{map.get(remaining)+1, i+1};
            }
            map.put(numbers[i], i);
		}

		return new int[] {};
    }
}
