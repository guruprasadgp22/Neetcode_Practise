class Node {
    int ele;
    int freq;

    Node(int ele, int freq) {
        this.ele = ele;
        this.freq = freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        Node[] arr = new Node[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[i++] = new Node(entry.getKey(), entry.getValue());
        }

        Arrays.sort(arr, (a, b) -> { return Integer.compare(b.freq, a.freq); });

        int res[] = new int[k];
        for (i = 0; i < k; i++) {
            res[i] = arr[i].ele;
        }

        return res;
    }
}
