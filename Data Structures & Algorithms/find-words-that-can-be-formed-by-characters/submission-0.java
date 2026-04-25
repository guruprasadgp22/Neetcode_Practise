class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;

        for(char ch: chars.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(String word: words) {
            HashMap<Character, Integer> current = new HashMap<>();

            for(char ch: word.toCharArray()) {
                current.put(ch, current.getOrDefault(ch, 0) + 1);
            }

            boolean isValid = true;

            for(char ch: current.keySet()) {
                if(current.get(ch) > map.getOrDefault(ch, 0)) {
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                count += word.length();
            }
        }

        return count;
    }
}