class Solution {
    private boolean isNumOrNot(String str) {
        if(str.matches("-?\\d+")) {
            return true;
        } else {
            return false;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String str: tokens) {
            if(isNumOrNot(str)) {
                int num = Integer.parseInt(str);
                stack.add(num);
                System.out.println(num);
            } else {
                char ch = str.charAt(0);
                int num2 = stack.pop();
                int num1 = stack.pop();

                if(ch == '+') {
                    int ans = num1 + num2;
                    stack.add(ans);
                    System.out.println(ans);
                } else if(ch == '-') {
                    int ans = num1 - num2;
                    stack.add(ans);
                    System.out.println(ans);
                } else if(ch == '*') {
                    int ans = num1 * num2;
                    stack.add(ans);
                    System.out.println(ans);
                } else if(ch == '/') {
                    int ans = num1/num2;
                    stack.add(ans);
                    System.out.println(ans);
                }
            }
        }

        return stack.pop();
    }
}
