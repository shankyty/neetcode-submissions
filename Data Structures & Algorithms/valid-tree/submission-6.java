class Solution {
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            int a = find(edge[0]);
            int b = find(edge[1]);
            if(a == b){
                return false;
            }
            parent[b] = a;
        }
        boolean result = false;
        for(int i = 0; i < n; i++){
            if(parent[i] == i){
                if(result){
                    return false;
                } else {
                    result = true;
                }
            }
        }
        return true;
    }

    int find(int a){
        if(a == parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }
}
