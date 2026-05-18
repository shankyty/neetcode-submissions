class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        for(int i = 0; i < result.length; i++){
            for(int[] interval : intervals){
                if(interval[0] <= queries[i] 
                    && queries[i] <= interval[1]){
                        result[i] = Math.min(interval[1] - interval[0] + 1, result[i]);
                }
            }
            if(result[i] == Integer.MAX_VALUE){
                result[i] = -1;
            }
        }
        return result;
    }
}