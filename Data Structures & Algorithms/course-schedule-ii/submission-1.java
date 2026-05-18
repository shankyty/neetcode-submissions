class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] preq : prerequisites){
            graph.computeIfAbsent(preq[1], __ -> new ArrayList<>(numCourses))
                .add(preq[0]);
        }
        //System.out.println(graph);
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
                Map<Integer, List<Integer>> graph, 
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
        for(Integer subject : graph.getOrDefault(idx, Collections.emptyList())){
            if(!_sort(subject, graph, state, ordered, index)){
                return false;
            }
        }
        ordered[index[0]--] = idx;
        state[idx] = 2;
        return true;
    }
}