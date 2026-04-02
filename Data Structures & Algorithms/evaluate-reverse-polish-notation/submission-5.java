class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack <Integer> stack = new Stack();
        for(int i = 0; i<tokens.length;i++){
        // for(char c : tokens){
            String token =tokens[i];
          if (token.length() == 1  && !isOperator(token.charAt(0))) {
            stack.push(Integer.parseInt(token));
            
            }else if(isOperator(token.charAt(0))){
                 if (stack.size() < 2) {
                    throw new IllegalArgumentException("Insufficient operands for operation");
                }
                int a=0,b = 0;
                a = stack.pop();
                b = stack.pop();
                switch (token.charAt(0)) {
                    case '+':
                        stack.push(b + a);  // b + a (because b is popped first)
                        break;
                    case '-':
                        stack.push(b - a);  // b - a
                        break;
                    case '*':
                        stack.push(b * a);  // b * a
                        break;
                    case '/':
                        stack.push(b / a);  // b / a
                        break;
                }
            }
          }
        
        return stack.peek();
    }
    public boolean isOperator(char c){
        return ( (c == '/') ||
                 (c == '*') ||
                 (c == '+') ||
                 (c == '-'));
    }

}
