class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack <Integer> stack = new Stack();
        for(int i = 0; i<tokens.length;i++){
        // for(char c : tokens){
            String token =tokens[i];
          if (token.length() == 1) {
            char c = token.charAt(0);
            if(Character.isDigit(c) ){
                stack.push(c -'0');
            }else if(isOperator(c)){
                int a=0,b = 0;
                a = stack.pop();
                b = stack.pop();
                switch(c){
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
        }
        return stack.peek();
    }
    public boolean isOperator(int c){
        return ( (c == '/') ||
                 (c == '*') ||
                 (c == '+') ||
                 (c == '-'));
    }

}
