class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;

        while(i < s.length()) {
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
            } else if(ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if(ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if(ch == ']' && !stack.isEmpty() && stack.peek() == '[' ) {
                stack.pop();
            } else {
                return false;
            }
            i++;
        }

        return stack.isEmpty();
    }
}
