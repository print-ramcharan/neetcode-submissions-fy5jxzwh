class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for(int i = bucket.length - 1; i >= 0 && counter < k; i --){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    res[counter++] = num;
                    if(counter == k) break;
                }
            }
        }
        return res;

    }
}
