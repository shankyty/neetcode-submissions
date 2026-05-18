class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Populate the graph via direct array access
        for (int[] preq : prerequisites) {
            graph[preq[1]].add(preq[0]);
            inDegree[preq[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
  
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
 
        int[] result = new int[numCourses];
        int idx = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            result[idx] = curr;
            idx++;
            for(int depenedent : graph[curr]){
                inDegree[depenedent]--;
                if(inDegree[depenedent] == 0){
                    queue.offer(depenedent);
                }
            }
        }
        if(idx != numCourses){
            return new int[0];
        }
        return result;
    }
}