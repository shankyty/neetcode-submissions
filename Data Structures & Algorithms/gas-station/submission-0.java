class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = -1;
        for(int i  = 0; i < n; i++){
            int tank = 0;
            boolean updateStart = true;
            for(int k = 0; k < n ; k++){
                tank+=gas[(i + k)%n];
                tank-=cost[(i + k)%n];
                if(tank < 0){
                    updateStart = false;
                    break;
                }
            }
            if(updateStart){
                start = i;
            }
        }
        return start;
    }
}
