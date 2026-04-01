class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int []x= new int[10];
        for(int i =0; i< nums.length; i++){     
                freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);    
               
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)-> freq.get(a)-freq.get(b));
        
        for(int num : freq.keySet()){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int []result = new int[k];
        int i=0;
        while(i!=k){
            result[i++]=minHeap.poll();

        }
        return result;
    }

}
