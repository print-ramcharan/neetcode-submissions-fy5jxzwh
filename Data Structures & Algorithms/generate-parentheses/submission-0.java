class Solution {
    public List<String> generateParenthesis(int n) {
        

        Stack<String> stack = new Stack();
        List<String> res = new ArrayList<>();;
       
        backTracking(0,0,n,stack,res);
        return res;
    }
    private void backTracking(int openC, int closedC, int n , Stack<String> stack, List<String> res){
            if(openC == n && closedC == n){
                 res.add(String.join("",stack));
                 return ;
            }
            if(openC < n){
                stack.push("(");
                backTracking(openC+1, closedC,n,stack,res);
                stack.pop();
            }
            if(closedC < openC){
                stack.push(")");
                backTracking(openC, closedC+1,n,stack,res);
                stack.pop();
            }
    }
}
