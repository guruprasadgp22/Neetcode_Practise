class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            int[] freq = new int[26];
            for(char ch:s.toCharArray()) {
                freq[ch - 'a']++;
            }

            String str = new String();
            for(int ele: freq) {
                str += ele + "#";
            }

            map.computeIfAbsent(str, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}