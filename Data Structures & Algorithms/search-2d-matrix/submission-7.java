class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        // while(i<matrix.length){
           
        //     i++;
        //  }
         boolean temp = false;
        for( i = 0 ; i < matrix.length ; i ++){
            if(target == matrix[i][0]){
                
                return true;
            }    
            if(target > matrix[i][0] ){
                temp =  binarySearch(matrix[i],0,matrix[i].length-1,target);
            }
            if(temp == true){
                return true;
            }
        }
        return false;
    }
    public boolean binarySearch(int[] row, int l, int r, int target) {
       while (l <= r) {
            int mid = l + (r - l) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
     
    }
}
