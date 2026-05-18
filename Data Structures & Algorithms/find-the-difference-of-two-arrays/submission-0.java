class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        TreeSet<Integer> set1 = new TreeSet<>();
        for(int ele: nums1) {
            set1.add(ele);
        }

        TreeSet<Integer> set2 = new TreeSet<>();
        for(int ele: nums2) {
            set2.add(ele);
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for(int ele: nums1) {
            if(set2.contains(ele)  || list1.contains(ele)) {
                continue;
            }

            list1.add(ele);
        }
        list.add(list1);
        List<Integer> list2 = new ArrayList<>();
        for(int ele: nums2) {
            if(set1.contains(ele) || list2.contains(ele)) {
                continue;
            }
            list2.add(ele);
        }

        list.add(list2);

        return list;
    }
}