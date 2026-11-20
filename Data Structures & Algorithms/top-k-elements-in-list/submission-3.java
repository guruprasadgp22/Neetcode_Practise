class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        int n = nums.length;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] arr = new ArrayList[n+1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int ele = entry.getKey();
            int freq = entry.getValue();

            if(arr[freq] == null) {
                arr[freq] = new ArrayList<>();
            }
            arr[freq].add(ele);
        }

        int j = 0;
        int res[] = new int[k];
        for (int i = n; i >= 0 && j < k; i--) {
            if(arr[i] == null) {
                continue;
            }

            int x = 0;
            int len = arr[i].size();

            while(x < len && j < k) {
                res[j] = arr[i].get(x);
                x++;
                j++;
            }

            if(j == k) {
                break;
            }
        }

        return res;
    }
}
