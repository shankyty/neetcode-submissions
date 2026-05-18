class Solution {
    public boolean canJump(int[] nums) {
        int lastJump = 0;
        for(int i = 0; i < nums.length;i++){
            if(lastJump >= i){
                lastJump = Math.max(lastJump, nums[i] + i);
            }
        }
        return lastJump >= nums.length - 1;
    }
}
