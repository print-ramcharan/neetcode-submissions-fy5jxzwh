class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

       int size = temperatures.length;
       int res[] = new int[size];
       for(int i = 0; i < size - 1  ; i++){
            for(int j = i+1; j< size ; j ++){
                if(temperatures[j] > temperatures[i]){
                    res[i] = j-i ;
                    break;
                }
            }    
       } 
       return res;
        
    }
}
