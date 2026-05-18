class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i <  edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            Set<Integer> visited = new HashSet<>();
            if(adj.containsKey(u) && adj.containsKey(v) && hasPath(u,v,adj, visited)){
                return edges[i];
            }
            adj.computeIfAbsent(u, __-> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, __-> new ArrayList<>()).add(u);
        }
        return new int[0];
    }

    boolean hasPath(int source, 
                    int target, 
                    Map<Integer, List<Integer>> adj, 
                    Set<Integer> visited){
        if(source == target){
            return true;
        }
        for(Integer next : adj.getOrDefault(source, Collections.emptyList())){
            if(!visited.contains(next)){
                visited.add(next);
                if(hasPath(next,target,adj, visited)){
                    return true;
                }
                
            }
        }
        return false;
    }
}
