class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int flight[] : flights){
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[] { flight[1], flight[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1], stops = curr[2];

            if(node == dst) return cost;
            
            if(stops > k) continue;

            if(!graph.containsKey(node)) continue;

            for(int[] next : graph.get(node)){
                int nextNode = next[0], nextCost = next[1];
                pq.offer(new int[]{cost + nextCost, nextNode, stops + 1});
            }
        }
        return -1;
    }
    
}
