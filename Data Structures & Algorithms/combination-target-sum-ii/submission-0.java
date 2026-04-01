class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> helper = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, new ArrayList<>(), target, result);
        return result;
    }
    private void dfs(int[] candidates, int index, List<Integer> helper, int target, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(helper));
            return;
        }
        if(target < 0 || index >= candidates.length){
            return;
        }
        // for(int i = index; i < candidates.length; i ++){

        // }
        
            helper.add(candidates[index]);
            dfs(candidates, index + 1, helper, target - candidates[index], result);
            helper.remove(helper.size() - 1);
            int next = index + 1;

            while(next < candidates.length && candidates[next] == candidates[index]){
                next ++;
            }
            dfs(candidates, next, helper, target, result);
        
        
    }
}
