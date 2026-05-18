class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compare);
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }
}
