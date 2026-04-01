class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int parent[] = new int[n + 1];
        int rank[] = new int[n + 1];

        for(int i = 0; i <= n; i ++){
            parent[i] = i;
            rank[i] = i;
        }
        for(int edge[] : edges){
            int u = edge[0], v = edge[1];
            if(!union(u, v, parent, rank)){
                return edge;
            }
        }
        return new int[0];
    }
    private int find(int x, int parent[]){
        if(x != parent[x]){
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    private boolean union(int u, int v, int parent[], int rank[]){
        int pu = find(u, parent);
        int pv = find(v, parent);
        if(pv == pu) return false;
        if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        }else if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }else{
            parent[pv] = pu;
            rank[pu] ++;
        }
        return true;
    }
}
