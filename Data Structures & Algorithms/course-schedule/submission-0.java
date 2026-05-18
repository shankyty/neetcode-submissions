class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>(4);
        }
        for (int[] preq : prerequisites) {
            // preq[1] must be taken before preq[0]
            graph[preq[1]].add(preq[0]); 
        }
        int[] state = new int[numCourses];
        for(int i  = 0; i < numCourses; i++){
            if(!isAcyclic(i, graph, state)){
                return false;
            }
        }
        return true;
    }

    boolean isAcyclic(int idx, List<Integer>[] graph, int[] state){
        if(state[idx] == 1){
            return false;
        }
        if(state[idx] == 2){
            return true;
        }
        state[idx] = 1;
        for(int dependent : graph[idx]){
            if(!isAcyclic(dependent, graph, state)){
                return false;
            }
        }
        state[idx] = 2;
        return true;
    }
}
