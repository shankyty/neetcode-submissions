class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = intervals.length - 1;
        for(; i>= 0 && intervals[i][0] > newInterval[1]; i--){
            result.add(0, intervals[i]);
        }

        for(; i>= 0 && intervals[i][1] >= newInterval[0]; i--){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
        }
        result.add(0, newInterval);
        for(; i>= 0; i--){
            result.add(0, intervals[i]);
        }
        return result.toArray(new int[0][]);
    }
}
