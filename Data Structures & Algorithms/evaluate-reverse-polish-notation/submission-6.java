class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            // Check if the token is a number (not an operator)
            if (token.length() == 1 && !isOperator(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token.charAt(0))) {
                int a = stack.pop();
                int b = stack.pop();
                
                switch (token.charAt(0)) {
                    case '+':
                        stack.push(b + a);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(b * a);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                }
            }
        }

        return stack.peek();
    }

    public boolean isOperator(char c) {
        return (c == '/' || c == '*' || c == '+' || c == '-');
    }
}
