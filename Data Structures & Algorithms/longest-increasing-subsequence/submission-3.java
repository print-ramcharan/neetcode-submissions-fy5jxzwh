class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] nextRow = new int[n + 1];
        int[] currRow = new int[n + 1];

        for(int i = n - 1; i >= 0; i --){

            for(int prevIdx = i - 1; prevIdx >= -1; prevIdx --){

                int notInclude = nextRow[prevIdx + 1];

                int include = 0;

                if(prevIdx == -1 || nums[i] > nums[prevIdx]){
                    include = 1 + nextRow[i + 1];
                }

                currRow[prevIdx + 1] = Math.max(include, notInclude);
            }
            nextRow = currRow.clone();
        }
        return nextRow[0];
    }
}
