class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n < 2) {
            return n;
        }
        int[] freq = new int[256];
        Arrays.fill(freq, -1);
        int lastSeen = -1;
        int max = 0;

        for(int i=0;i<n;i++) {
            int j = s.charAt(i) - ' ';
            lastSeen = Math.max(lastSeen, freq[j]);
            max = Math.max(max, i - lastSeen);
            freq[j] = i;
        }
        return max;
    }
}
