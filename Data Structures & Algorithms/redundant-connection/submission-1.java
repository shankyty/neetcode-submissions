class Solution {
    int[] parents;
    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[edges.length + 1];
        for(int i = 0; i <  edges.length; i++){
            parents[i]= i;
        }
        for(int i = 0; i <  edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int uP = find(u);
            int vP = find(v);
            if(uP == vP){
                return edges[i];
            }
            parents[vP] = uP;
        }
        return new int[0];
    }

    int find(int a){
        if(parents[a] == a){
            return a;
        }
        return parents[a] = find(parents[a]);
    }
}
