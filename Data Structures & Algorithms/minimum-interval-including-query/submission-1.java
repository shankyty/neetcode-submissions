class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        List<int[]> events = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            events.add(new int[]{intervals[i][0], 0, intervals[i][1] - intervals[i][0] + 1, i});
            events.add(new int[]{intervals[i][1], 2, intervals[i][1] - intervals[i][0] + 1, i});
        }
        for(int i = 0; i < queries.length; i++){
            events.add(new int[]{queries[i], 1, 0, i});
        }
        events.sort((a, b) -> a[0] != b[0] ?
                  Integer.compare(a[0], b[0]) :
                  Integer.compare(a[1], b[1]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        boolean[] inactive = new boolean[intervals.length];
        for(int[] event :  events){
            if(event[1] == 0){
                pq.offer(new int[]{event[2], event[3]});
            } else if(event[1] == 2){
                inactive[event[3]] = true;
            } else {
                while(!pq.isEmpty() && inactive[pq.peek()[1]]){
                    pq.poll();
                }
                if(!pq.isEmpty()){
                    result[event[3]] = pq.peek()[0];
                }
            }
        }
        return result;
    }
}