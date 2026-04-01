class Solution {
    public int appendCharacters(String s, String t) {
        int k = 0;

        for(int i = 0; i < s.length(); i++) {
            if(k < t.length() && s.charAt(i) == t.charAt(k)) {
                k++;
            }
        }

        return t.length() - k;
    }
}