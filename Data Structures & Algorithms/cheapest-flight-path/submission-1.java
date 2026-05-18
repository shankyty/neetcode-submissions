class Solution {
    public int findCheapestPrice(int n, 
                                int[][] flights, 
                                int src, 
                                int dst, 
                                int k) {

        int[][] costs = new int[n][n];
        for(int i = 0; i < flights.length; i++){
            int s = flights[i][0];
            int d = flights[i][1];
            costs[s][d] = flights[i][2];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);
        pq.offer(new int[]{src, 0, 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int cost = curr[1];
            int hops = curr[2];
            
            if(u == dst) return cost;
            if(hops > k) continue;
            
            if(hops >= minStops[u]) continue;
            minStops[u] = hops;

            for(int v = 0; v < n; v++){
                if(costs[u][v] != 0){
                    pq.offer(new int[]{v, cost + costs[u][v], hops + 1});
                }
            }
        }
        return -1;
    }
}