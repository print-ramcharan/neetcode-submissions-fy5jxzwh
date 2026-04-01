class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            String source = ticket.get(0), destination = ticket.get(1);
            graph.computeIfAbsent(source, k -> new PriorityQueue<>()).add(destination);
        }

        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", graph, result);
        return result;
    }
    private void dfs(String src, Map<String, PriorityQueue<String>> graph, LinkedList<String> result){
        PriorityQueue<String> pq = graph.getOrDefault(src, new PriorityQueue<>());

        while(!pq.isEmpty()){
            String dest = pq.poll();
            dfs(dest, graph, result);
        }
        result.addFirst(src);
    }
        // Queue<String> queue = new LinkedList<>();

        // queue.offer("JFK");
        // List<String> visited = new ArrayList<>();
        
        // List<String> result = new ArrayList<>();
        // result.add("JFK");
        
        // while(!queue.isEmpty()){
        //     String src = queue.poll();
        //     PriorityQueue<String> pq = graph.getOrDefault(src, new PriorityQueue<>());

        //     while (!pq.isEmpty()) {
        //         String dest = pq.poll(); // safely removes and returns the smallest element
    
        //             result.add(dest);
        //             visited.add(dest);
        //             if(graph.containsKey(dest)){
        //                 dfs()
        //             }
        //             // no need to manually remove again since poll() already did it
                
        //     }

            // for(String dest : graph.getOrDefault(src, new ArrayList<>())){
                
            //         if(graph.containsKey(dest)){
            //             result.add(dest);
            //             visited.add(dest);
            //             graph.get(src).remove(dest);
            //         }
            // }

    //     }

    //     return result;
    // }

}

