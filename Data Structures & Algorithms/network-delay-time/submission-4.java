class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0 ; i < times.length; i++){
            adj.computeIfAbsent(times[i][0], __ -> new ArrayList<>()).add(i);
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        dist[k] = 0;
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[1] > dist[curr[0]]){
                continue;
            }
            List<Integer> edges = adj.getOrDefault(curr[0], Collections.emptyList());        
            for(Integer edge : edges){
                int next = times[edge][1];
                int time = times[edge][2];
                if(dist[curr[0]] + time <  dist[next]){
                    pq.remove(next);
                    dist[next] = dist[curr[0]] + time;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            if(dist[i] > max){
                max = dist[i];
            }
        }
        return max;
    }
}