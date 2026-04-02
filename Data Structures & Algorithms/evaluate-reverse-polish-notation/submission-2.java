class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack <Integer> stack = new Stack();
        for(int i = 0; i<tokens.length;i++){
        // for(char c : tokens){
            String token =tokens[i];
          if (token.length() == 1  && !isOperator(token.charAt(0))) {
            stack.push(Integer.parseInt(token));
            
            }else if(isOperator(token.charAt(0))){
                int a=0,b = 0;
                a = stack.pop();
                b = stack.pop();
                switch(token.charAt(0)){
                    case '+':
                            stack.push(a+b);
                            break;
                     case '-':
                            stack.push(a-b);
                            break;
                     case '*':
                            stack.push(a*b);
                            break;
                     case '/':
                            stack.push(a/b);
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
