class Solution {
    public int minimumRecolors(String blocks, int k) {
        int count = 0;
        int max = 0;
        for(int i=0;i<k;i++) {
            if(blocks.charAt(i) == 'B') {
                count++;
            }
        }
        max = Math.max(max, count);

        for(int i=k;i<blocks.length();i++) {
            if(blocks.charAt(i-k) == 'B') {
                count--;
            }

            if(blocks.charAt(i) == 'B') {
                count++;
            }
            max = Math.max(max, count); 
        }

        return k - max;
    }
}