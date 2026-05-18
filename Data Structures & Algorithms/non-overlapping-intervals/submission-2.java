class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> {
            int startComp = Integer.compare(a[1], b[1]);
            if(startComp == 0){
                return Integer.compare(a[1] - a[0], b[1] - b[0]);
            }
            return startComp;
        });
        int count = 0;
        /*System.out.println(Arrays.stream(intervals)
                                .map(Arrays::toString)
                                .collect(Collectors.joining(",")));*/
        for(int i  = 0; i < n;){
            int next = intervals[i][1];
            int j = i + 1;
            for( ;j < n && intervals[j][0] < next;j++);
            if(j >= n || intervals[j][0] >= next){
                count++;
                i = j;
            }
        }
        return n - count;
    }
}
