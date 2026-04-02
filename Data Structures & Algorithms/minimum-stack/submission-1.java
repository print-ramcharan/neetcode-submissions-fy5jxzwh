class MinStack {
    int min;
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
            min = val;
        }else{
            if(val<min){
            
                stack.push(2*val-min);
                min = val;
            }else{
                stack.push(val);
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
         if (top < min) {
             min = 2 * min - top;
        }
    }
    
    public int top() {
         int top = stack.peek();
        if (top < min) {
            return min;  
         }
        return top;
    }
    
    public int getMin() {
        return min;
        
    }
}
