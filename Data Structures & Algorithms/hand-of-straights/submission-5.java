class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> frq = new HashMap<>();
        for(int n : hand){
            frq.put(n,frq.getOrDefault(n, 0) + 1);
        }
    
        for(int i = 0; i < 1000 - 3; i++){
            if(frq.containsKey(i)){
                boolean isGroupPossible = true;
                do{
                    isGroupPossible = true;
                    for(int k = 0; k < groupSize; k++){
                       isGroupPossible = isGroupPossible 
                            && frq.getOrDefault( i + k, 0) > 0 ;
                    }
                    
                    if(isGroupPossible){
                        for(int k = 0; k < groupSize; k++){
                            int count = frq.get( i + k);
                            count--;
                            if(count == 0){
                                frq.remove(i + k);
                            } else {
                                frq.put(i + k, count);
                            }
                        }
                    }
                } while(isGroupPossible);
            }
        }
        return frq.isEmpty();
    }
}
