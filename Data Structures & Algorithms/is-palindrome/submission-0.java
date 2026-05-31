class Solution {
    public boolean isPalindrome(String s) {
        String ans = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String temp = ans;

        char[] arr = temp.toCharArray();

        int left = 0;
        int right = temp.length()-1;

        while(left < right) {
            char ch = arr[left];
            arr[left] = arr[right];
            arr[right] = ch;
            left++;
            right--;    
        }

        String dup = new String(arr);
        return ans.equals(dup) ? true: false;            
    }
}
