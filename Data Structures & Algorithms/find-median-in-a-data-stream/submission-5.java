class MedianFinder {

    // Brute Force
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {   
        list.add(num);
       
    }
    
    public double findMedian() {
         Collections.sort(list);
        if(list.size() % 2 == 1) {
            int mid = list.size() / 2;
            double ans = list.get(mid);
            return ans;
        } else {
            int mid1 = list.size() / 2;
            int mid2 = mid1 - 1;
            double ans = (list.get(mid1) + list.get(mid2))/2.0;
            return ans;
        }
    }
}
