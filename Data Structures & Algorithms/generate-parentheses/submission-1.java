class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        solve(0, 0, new StringBuilder(), n);
        return result;
    }

    private void solve(int open, int close, StringBuilder curr, int n) {
        if(curr.length() == 2 * n) {
            result.add(curr.toString());
            return;
        }

        if(open < n){
            curr.append("(");
            solve(open+1, close, curr, n);
            curr.deleteCharAt(curr.length()-1);
        }

        if(close < open) {
            curr.append(")");
            solve(open, close+1, curr, n);
            curr.deleteCharAt(curr.length()-1);
        } 
    }
}
