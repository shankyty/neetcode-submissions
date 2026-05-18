class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > this.k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() >= k){
            if(pq.peek() <= val){
                pq.offer(val);
                pq.poll();
            }
        } else {
            pq.offer(val);
        }
        return pq.peek();
    }
}
