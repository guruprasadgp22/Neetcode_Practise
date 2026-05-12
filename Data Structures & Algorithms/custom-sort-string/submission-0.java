class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> table = new HashMap<>();
        HashSet<Character> set = new HashSet<>();


        for(char ch: s.toCharArray()) {
            table.put(ch, table.getOrDefault(ch, 0) + 1);
            set.add(ch);
        }

        String ans = "";

        for(char ch: order.toCharArray()) {
            if(!table.containsKey(ch)) {
                continue;
            }
            int count = table.get(ch);
            System.out.println(ch + " " + count);
            while(count > 0) {
                ans += String.valueOf(ch);
                count--;
            }
            set.remove(ch);
        }

        for(char ch: set) {
            int count = table.get(ch);

            while(count > 0) {
                ans += String.valueOf(ch);
                count--;
            }
        }

        return ans;
    }
}