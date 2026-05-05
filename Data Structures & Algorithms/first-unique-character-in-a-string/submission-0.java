class Pair {
    int count;
    int index;

    Pair(int count, int index) {
        this.count = count;
        this.index = index;
    }
}
class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Pair> map = new LinkedHashMap<>();

        for(int i=0;i<s.length();i++) {
            Pair p = map.getOrDefault(s.charAt(i), new Pair(0, -1));
            map.put(s.charAt(i), new Pair(p.count+1, i));
        }

        for(Map.Entry<Character, Pair> entry: map.entrySet()) {
            if(entry.getValue().count == 1) {
                return entry.getValue().index;
            }
        }

        return -1;
    }
}