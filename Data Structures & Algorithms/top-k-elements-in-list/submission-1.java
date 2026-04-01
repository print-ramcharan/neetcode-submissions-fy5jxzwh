class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length +1];
        for(int i = 0; i <= nums.length; i ++){
            buckets[i] = new ArrayList<>();
        }
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            buckets[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = buckets.length -1; i >= 0 && index < k; i --){
            for(int n : buckets[i]){
                res[index++] = n;
                if(index == k) return res;
            }
        }
        return res;
        // List<Integer> res = new ArrayList<>();
        // for(int i = buckets.length -1; k > map.size() && i >= 0 ; i --){
        //     if(!buckets[i].isEmpty()){
        //         res.addAll(buckets[i]);
        //     }
        // }
        // return res.stream().mapToInt(i -> i).toArray();
    }
}
