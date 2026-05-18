class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 0 ; i < times.length; i++){
            if(adj[times[i][0]] == null){
                adj[times[i][0]] = new ArrayList<>(3);
            }
            adj[times[i][0]].add(i);
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
            if(adj[curr[0]] != null){
                List<Integer> edges = adj[curr[0]];        
                for(Integer edge : edges){
                    int next = times[edge][1];
                    int time = times[edge][2];
                    if(dist[curr[0]] + time <  dist[next]){
                        dist[next] = dist[curr[0]] + time;
                        pq.offer(new int[]{next, dist[next]});
                    }
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