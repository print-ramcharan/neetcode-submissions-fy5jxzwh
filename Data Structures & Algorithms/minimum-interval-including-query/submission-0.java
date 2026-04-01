class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = queries.length;
        int[] res = new int[n];

        int[][] queriesWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }

        Arrays.sort(queriesWithIndex, (a, b) -> a[0] - b[0]); 

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;

        for (int[] q : queriesWithIndex) {
            int query = q[0];
            int idx = q[1];

            while (i < intervals.length && intervals[i][0] <= query) {
                int length = intervals[i][1] - intervals[i][0] + 1;
                heap.offer(new int[]{length, intervals[i][1]});
                i++;
            }

            while (!heap.isEmpty() && heap.peek()[1] < query) {
                heap.poll();
            }

            res[idx] = heap.isEmpty() ? -1 : heap.peek()[0];
        }
        return res;

    }
}