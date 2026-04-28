class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        int max = 0;
        char ch[] = num.toCharArray();
        String samNum = String.valueOf(ch[0]);
        for(int i=1;i<ch.length;i++) {
            if(ch[i-1] == ch[i]) {
                samNum += String.valueOf(ch[i]);
            } else {
                samNum = String.valueOf(ch[i]);
            }

            if(samNum.length() == 3) {
                max = Math.max(max, Integer.parseInt(samNum));
                ans = String.valueOf(max);
            }
        }

        return (ans.equals("0")) ? "000" : ans;
    }
}