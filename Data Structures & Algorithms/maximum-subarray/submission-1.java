class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 1;
        int max = nums[0];
        int sum = nums[0];
        while(right < n){
            while(sum < 0 && left <= right){
                sum -= nums[left];
                left++;
            }
            sum += nums[right];
            max = Math.max(sum,max);
            right++;
        }
        return max;
    }
}
