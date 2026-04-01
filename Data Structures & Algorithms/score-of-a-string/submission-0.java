class Solution {
    public int scoreOfString(String s) {
        int diff = 0;
        char str[] = s.toCharArray();

        for(int i=0;i<str.length-1;i++) {
            diff += Math.abs(str[i+1] - str[i]);
        }

        return diff;
    }
}