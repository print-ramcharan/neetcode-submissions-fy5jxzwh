class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    private Set<Integer> visited = new HashSet<>();
    private List<Integer> result = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            preMap.get(pre[0]).add(pre[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0]; // cycle detected
            }
        }

        // reverse result to get correct order
        // Collections.reverse(result);

        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = result.get(i);
        }
        return order;
    }

    private boolean dfs(int curr) {
        if (visiting.contains(curr)) return false; // cycle
        if (visited.contains(curr)) return true;  // already processed

        visiting.add(curr);
        for (int pre : preMap.get(curr)) {
            if (!dfs(pre)) return false;
        }
        visiting.remove(curr);
        visited.add(curr);

        result.add(curr); // add after processing all prerequisites
        return true;
    }
}
