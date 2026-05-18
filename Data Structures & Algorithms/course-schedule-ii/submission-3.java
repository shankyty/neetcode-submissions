class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Populate the graph via direct array access
        for (int[] preq : prerequisites) {
            graph[preq[1]].add(preq[0]);
        }
        
        int[] ordered = new int[numCourses];
        int[] state = new int[numCourses];
        int[] index = new int[]{numCourses - 1};
        for(int i  = 0; i < numCourses; i++){
            if(state[i] == 0){
                if(!_sort(i, graph, state, ordered, index)){
                    return new int[0];
                }
            }
        }
        return ordered;
    }

    boolean _sort(int idx, 
                List<Integer>[] graph, 
                int[] state, 
                int[] ordered,
                int[] index){
        if(state[idx] == 1){
            return false;
        }
        if(state[idx] == 2){
            return true;
        }
        
        state[idx] = 1;
        for(Integer subject : graph[idx]){
            if(!_sort(subject, graph, state, ordered, index)){
                return false;
            }
        }
        ordered[index[0]--] = idx;
        state[idx] = 2;
        return true;
    }
}