class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];
        
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] == n - 1 && curr[2] == n - 1) return curr[0];
            
            for (int[] d : dirs) {
                int ni = curr[1] + d[0], nj = curr[2] + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    pq.offer(new int[]{Math.max(curr[0],grid[ni][nj]), ni, nj});
                }
            }
        }
        return -1;
    }
}