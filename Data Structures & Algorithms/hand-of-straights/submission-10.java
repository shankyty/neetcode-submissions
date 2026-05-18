class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) 
            return false;

        TreeMap<Integer, Integer> frq = new TreeMap<>();

        for(int n : hand){
            frq.put(n, frq.getOrDefault(n, 0) + 1);
        }

        boolean isGroupPossible = true;

        do{
            int start = frq.firstKey();
            isGroupPossible = true;
            for(int k = 0; k < groupSize; k++){
                isGroupPossible = isGroupPossible 
                    && frq.getOrDefault(start + k, 0) > 0 ;
            }
            if(isGroupPossible){
                for(int k = 0; k < groupSize; k++){
                    int count = frq.get( start + k);
                    count--;
                    if(count == 0){
                        frq.remove(start + k);
                    } else {
                        frq.put(start + k, count);
                    }
                }
            }
        } while(!frq.isEmpty() && isGroupPossible);

        return frq.isEmpty();
    }
}
