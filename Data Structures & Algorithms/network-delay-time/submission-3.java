class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0 ; i < times.length; i++){
            adj.computeIfAbsent(times[i][0], __ -> new ArrayList<>()).add(i);
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(dist[a], dist[b]));
        dist[k] = 0;
        pq.offer(k);
        while(!pq.isEmpty()){
            int idx = pq.poll();
            List<Integer> edges = adj.getOrDefault(idx, Collections.emptyList());
            for(Integer edge : edges){
                int next = times[edge][1];
                int time = times[edge][2];
                if(dist[idx] + time <  dist[next]){
                    pq.remove(next);
                    dist[next] = dist[idx] + time;
                    pq.offer(next);
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