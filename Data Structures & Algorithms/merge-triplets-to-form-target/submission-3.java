class Solution {
    public boolean mergeTriplets(int[][] triplets, 
                                    int[] target) {
        int n = triplets.length;
        boolean[] hasElement = new boolean[3];
        Arrays.fill(hasElement, false);
        for(int i = 0; i < n && (!(hasElement[0] && hasElement[1] && hasElement[2])); i++){
            int[] current = triplets[i];
            hasElement[0] = hasElement[0] || 
                            (target[0] == current[0]
                                && target[1] >= current[1] 
                                && target[2] >= current[2]);
            hasElement[1] = hasElement[1] || 
                            (target[1] == current[1]
                                && target[0] >= current[0] 
                                && target[2] >= current[2]);
            hasElement[2] = hasElement[2] || 
                            (target[2] == current[2]
                                && target[0] >= current[0] 
                                && target[1] >= current[1]);
        }
        return hasElement[0] && hasElement[1] && hasElement[2];
    }

}