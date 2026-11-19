class Solution {
    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
        79, 83, 89, 97, 101};
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long, List<String>> map = new HashMap<>();
        for (String s : strs) {
            long res = 1;
            for(char ch: s.toCharArray()) {
                res *= primes[ch - 'a'];
            }
            map.computeIfAbsent(res, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}