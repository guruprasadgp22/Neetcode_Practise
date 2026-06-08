class Solution {
    public int compress(char[] chars) {
        int read = 0;
        int write = 0;
        int n = chars.length;
        while(read < n) {
            int count = 0;
            char curr = chars[read];
            while(read < n && curr == chars[read]) {
                count++;
                read += 1;
            }

            chars[write++] = curr;

            if(count > 1) {
                for(char ch: String.valueOf(count).toCharArray()) {
                    chars[write] = ch;
                    write++;
                }
            }
        }

        return write;
    }
}