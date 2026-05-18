class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        for(int stone : stones){
            maxHeap.offer(stone);
        }
        while(maxHeap.size() >= 2){
            int big = maxHeap.poll();
            int small = maxHeap.poll();
            if(big == small){
                continue;
            }
            maxHeap.offer(big - small);
        }
        return maxHeap.size() == 0? 0 : maxHeap.peek();
    }
}
