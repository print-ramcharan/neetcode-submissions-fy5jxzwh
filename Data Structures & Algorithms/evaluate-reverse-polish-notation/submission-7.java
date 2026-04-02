class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack <Integer> stack = new Stack();
       
        for(String token : tokens){
            
            if(isOperator(token)){
                
                int a = stack.pop();
                int b = stack.pop();
                 switch(token){
                    case "+":
                            stack.push(a+b);
                            break;
                     case "-":
                            stack.push(a-b);
                            break;
                     case "*":
                            stack.push(a*b);
                            break;
                     case "/":
                            stack.push(a/b);
                            break;
                }
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
    public boolean isOperator(String c){
        return ( c.equals("/") ||
                 c.equals("*") ||
                 c.equals("+") ||
                 c.equals("-"));
    }

}
