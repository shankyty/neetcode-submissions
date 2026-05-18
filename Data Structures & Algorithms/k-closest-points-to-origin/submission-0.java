class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> Integer.compare((b[0]*b[0] + b[1]*b[1]),(a[0]*a[0] + a[1]*a[1])));
        for(int[] point : points){
            pq.offer(point);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] result = new int[pq.size()][];
        for(int i = pq.size() - 1; i >= 0; i--){
            result[i] = pq.poll();
        }
        return result;
    }
}
