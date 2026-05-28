class CountSquares {
    private Map<Integer, Map<Integer, Integer>> xBuckets;

    public CountSquares() {
        xBuckets = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        xBuckets.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yValues = xBuckets.get(x);
        yValues.put(y, yValues.getOrDefault(y, 0) + 1); 
    }
    
    public int count(int[] point) {

        int qx = point[0];
        int qy = point[1];
        int totalSquares = 0;

        for(int dx : xBuckets.keySet()){
            if(dx == qx) continue;

            int sideLength = Math.abs(dx - qx);

            totalSquares += checkSquareCorners(qx, qy, dx, qy + sideLength);
            totalSquares += checkSquareCorners(qx, qy, dx, qy - sideLength);

        }
        return totalSquares;
        
    }

    private int checkSquareCorners(int qx, int qy, int dx, int dy){
        if(dy < 0 || dy > 1000) return 0;

        Map<Integer, Integer> dYmap = xBuckets.get(dx);

        if(dYmap == null || !dYmap.containsKey(dy)) return 0;

        int dCount = dYmap.get(dy);

        int c1Count = dYmap.getOrDefault(qy, 0);
        if(c1Count == 0) return 0;

        Map<Integer, Integer> qYmap = xBuckets.get(qx);
        int c2Count = (qYmap != null) ? qYmap.getOrDefault(dy, 0) : 0;

        if(c2Count == 0) return 0;

        return dCount * c1Count * c2Count;
    }
}
