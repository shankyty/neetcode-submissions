class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] jumps = new int[n];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= nums[i] && i + j < n;j++){
                jumps[i + j] = Math.min(jumps[i + j],
                                jumps[i] + 1);
            }
        }

        return jumps[n - 1] == Integer.MAX_VALUE ? -1 : jumps[n - 1];
    }
}
