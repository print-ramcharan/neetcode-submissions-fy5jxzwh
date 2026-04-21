class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i ++){
            if(!map.containsKey(numbers[i])){
                map.put(numbers[i], i);
            }    
        }
        for(int i = 0; i < n; i ++){
            int diff = target - numbers[i];
            if(map.containsKey(diff)){
                return new int[] {map.get(diff), diff};
            }
        }
        return new int[]{-1};
    }
}
