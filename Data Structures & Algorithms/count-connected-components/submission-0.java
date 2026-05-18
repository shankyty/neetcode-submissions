class Solution {
    int[] parents;
    public int countComponents(int n, int[][] edges) {
        parents = new int[n + 1];
        for(int i = 0; i <= n; parents[i] = i, i++);
        for(int[] edge : edges){
            union(edge[0], edge[1]);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(parents[i] == i){
                count++;
            }
        }
        return count;
    }

    private void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parents[a] = b;
        }
    }
    int find(int a){
        if(a == parents[a]){
            return a;
        }
        return parents[a] = find(parents[a]);
    }
}
