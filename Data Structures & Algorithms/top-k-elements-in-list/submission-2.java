class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, List<Integer>> result = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: num → freq
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: freq → list of nums (FIX HERE)
        for (int key : map.keySet()) {
            int freq = map.get(key);

            result.putIfAbsent(freq, new ArrayList<>());
            result.get(freq).add(key);
        }

        // Step 3: collect top k
        int[] res = new int[k];
        int index = 0;

        int maxFreq = nums.length;

        for (int i = maxFreq; i >= 1 && index < k; i--) {
            if (result.containsKey(i)) {
                for (int num : result.get(i)) {
                    res[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return res;
    }
}