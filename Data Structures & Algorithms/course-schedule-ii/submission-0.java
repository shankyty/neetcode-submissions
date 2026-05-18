class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] preq : prerequisites){
            graph.computeIfAbsent(preq[1], __ -> new ArrayList<>(numCourses))
                .add(preq[0]);
        }
        //System.out.println(graph);
        List<Integer> ordered = new ArrayList<>();
        int[] state = new int[numCourses];
        Arrays.fill(state, 0);
        for(int i  = 0; i < numCourses; i++){
            if(state[i] == 0){
                if(!_sort(i, graph, state, ordered)){
                    return new int[0];
                }
            }
        }
        Collections.reverse(ordered);
        return ordered.stream()
                   .mapToInt(Integer::intValue)
                   .toArray();
    }

    boolean _sort(int idx, 
                Map<Integer, List<Integer>> graph, 
                int[] state, 
                List<Integer> ordered){
        if(state[idx] == 1){
            return false;
        }
        if(state[idx] == 0){
            state[idx] = 1;
            for(Integer subject : graph.getOrDefault(idx, Collections.emptyList())){
                if(!_sort(subject, graph, state, ordered)){
                    return false;
                }
            }
            ordered.add(idx);
            state[idx] = 2;
            
        }
        return true;
    }
}