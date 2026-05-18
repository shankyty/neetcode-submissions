class MedianFinder {

    List<Integer> result = new ArrayList<>();

    public MedianFinder() {

    }
    
    public void addNum(int num) {
        this.result.add(num);
    }
    
    public double findMedian() {
        Collections.sort(result);
        int n = result.size();
        if(n % 2 == 0){
            return (result.get(n/2 - 1) + result.get(n/2))/2.0d;
        }
        return result.get(n/2) * 1.0d;
    }
}
