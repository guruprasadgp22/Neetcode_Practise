class Solution {
public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int ele : nums) {
			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}

		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a[1], b[1]);
		});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			queue.add(new int[] { entry.getKey(), entry.getValue() });

			while (queue.size() > k) {
				queue.poll();
			}
		}

		int res[] = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = queue.poll()[0];
		}

		return res;
	}
}
