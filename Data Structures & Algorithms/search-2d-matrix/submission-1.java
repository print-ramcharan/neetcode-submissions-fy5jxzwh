class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0 ; i < matrix.length ; i ++){
            // for(int j = 0; j < matrix[i].length ; j ++){
                
            // }
            if(target == matrix[i][0]){
                return true;
            }else if(target < matrix[i+1][0]){
                return binarySearch(matrix[i],0,matrix[i].length-1,target);
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
