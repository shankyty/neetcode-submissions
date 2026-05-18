class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            int comp = Integer.compare(a[0],b[0]);
            if(comp == 0){
                return Integer.compare(a[1],b[1]);
            }
            return comp;
        });
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int[] current = new int[]{intervals[0][0], intervals[0][1]};
        for(int i  = 1; i < n; i++){
            if(doesOverlap(current, intervals[i])){
                current[0] = Math.min(current[0], intervals[i][0]);
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = new int[]{intervals[i][0], intervals[i][1]};
            }
        }
        result.add(current);
        int[][] resultA = result.toArray(new int[0][]);
        return resultA;
    }

    boolean doesOverlap(int[] first, int[] second){
        return (first[0] <= second[0] && second[0] <= first[1])
            || (first[0] <= second[1] && second[1] <= first[1]);
    }
}