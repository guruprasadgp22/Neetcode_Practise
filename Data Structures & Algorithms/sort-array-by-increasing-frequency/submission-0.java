class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        Integer[] arr = new Integer[nums.length];

        for(int i=0;i<nums.length;i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) ->{
            int freq1 = map.get(a);
            int freq2 = map.get(b);

            if(freq1 != freq2) {
                return freq1 - freq2;
            }

            return b - a;
        });

        for(int i=0;i<nums.length;i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}