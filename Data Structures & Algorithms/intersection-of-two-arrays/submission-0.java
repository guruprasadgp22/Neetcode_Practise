class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        TreeSet<Integer> result = new TreeSet<>();

        for(int ele: nums1) {
            set.add(ele);
        }

        for(int ele: nums2) {
            if(set.contains(ele)) {
                result.add(ele);
            }
        }

        int[] ans = new int[result.size()];
        int i=0;
        for(int ele: result) {
            ans[i++] = ele;
        }

        return ans;
    }
}