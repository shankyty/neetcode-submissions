class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Integer, Integer> idx = new HashMap<>();
        char[] sA = s.toCharArray();
        for(int i = 0; i < sA.length; i++){
            int last = idx.getOrDefault(sA[i], i - 1);
            idx.put(sA[i] + 0,i > last ? i : last);
        }
        List<Integer> partions = new ArrayList<>();
        partions.add(-1);
        int currentPartionEmd = 0;
        for(int i = 0; i < sA.length; i++){
            int last = idx.get(sA[i] + 0);
            currentPartionEmd = last > currentPartionEmd ? last : currentPartionEmd;
            if(currentPartionEmd == i){
                partions.add(currentPartionEmd);
            }
        }
        List<Integer> result = new ArrayList<>(partions.size() - 1);
        for(int i = 1; i < partions.size(); i++){
            result.add(partions.get(i) - partions.get(i - 1));
        }
        return result;
    }
}
