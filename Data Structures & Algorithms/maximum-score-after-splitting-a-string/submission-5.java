class Solution {
    public int maxScore(String s) {
        if(s.matches("1+") || s.matches("0+")) {
            return s.length()-1;
        }

        int[] leftZero = new int[s.length()];
        int[] rightOne = new int[s.length()];

        int count = 0;
        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i) == '0') {
                count++;
            }

            leftZero[i] = count;
        }        

        count = 0;

        for(int i=s.length()-1;i>0;i--){
            if(s.charAt(i) == '1') {
                count++;
            }

            rightOne[i] = count;
        }

        int max = 0;

        for(int i=0;i<s.length()-1;i++) {
            int sum = leftZero[i] + rightOne[i+1];
            max = Math.max(max, sum);
        }

        return max;
    }
}