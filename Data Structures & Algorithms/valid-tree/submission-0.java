class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n - 1) return false;
        
        int[] parent = new int[n];
        for(int i = 0; i < n; i ++){
            parent[i] = i;
        }
        
        for(int [] edge : edges){
            if(!union(edge[0], edge[1], parent)) return false;
        }
        return true;
    }
    private int find(int x, int[] parent){
            if(parent[x] != x) parent[x] = find(parent[x], parent);
            return parent[x];
    }

    private boolean union(int a, int b, int[] parent){
            int rootA = find(a, parent);
            int rootB = find(b, parent);
            if(rootA == rootB) return false;
            parent[rootA] = rootB;
            return true;
    }
}
