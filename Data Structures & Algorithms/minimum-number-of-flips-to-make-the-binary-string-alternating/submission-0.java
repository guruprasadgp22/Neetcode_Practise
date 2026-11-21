class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < n; i++) {
            char ch1 = i % 2 == 0 ? '0' : '1';
            char ch2 = i % 2 == 1 ? '0' : '1';
            if (s.charAt(i) != ch1) {
                res1++;
            }

            if (s.charAt(i) != ch2) {
                res2++;
            }
        }

        int minFlip = Math.min(res1, res2);

        for (int i = n; i < 2 * n; i++) {
            char ch1 = i % 2 == 0 ? '0' : '1';
            char ch2 = i % 2 == 1 ? '0' : '1';
            char prevCh1 = (i - n) % 2 == 0 ? '0' : '1';
            char prevCh2 = (i - n) % 2 == 1 ? '0' : '1';

            if (s.charAt(i % n) != ch1) {
                res1++;
            }

            if (s.charAt(i % n) != prevCh1) {
                res1--;
            }

            if (s.charAt(i % n) != ch2) {
                res2++;
            }

            if (s.charAt(i % n) != prevCh2) {
                res2--;
            }

            minFlip = Math.min(minFlip, Math.min(res1, res2));
        }
        return minFlip;
    }
}
