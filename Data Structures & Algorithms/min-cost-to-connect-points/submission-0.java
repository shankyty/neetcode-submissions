class Solution {
    public int minCostConnectPoints(int[][] points) {
        int totalWeight = 0;
        int n = points.length;
        Set<Integer> selected = new HashSet<>();
        selected.add(0);
        while(selected.size() < n){
            int minW = Integer.MAX_VALUE;
            int v = -1;
            for(Integer i : selected){
                for(int j = 0; j < n; j++){
                    if(!selected.contains(j)){
                        int dist = getDist(points[i], points[j]);
                        if(dist < minW){
                            minW = dist;
                            v = j;
                        }
                    }
                }
            }
            if(minW != Integer.MAX_VALUE && v != -1){
                selected.add(v);
                totalWeight += minW;
            } else {
                break;
            }
        }
        return totalWeight;
    }

    int getDist(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
