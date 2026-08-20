class MedianFinder {

    // Heap Solution
    PriorityQueue<Integer> smallHeap; // => Max Heap
    PriorityQueue<Integer> largeHeap; // => Min Heap

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        largeHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        // After defaultly adding to small heap, need to check 2 conditions
        //Condition 1:
        if(!largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) {
            largeHeap.add(smallHeap.poll());
        }

        // Condition 2:
        if(smallHeap.size() > largeHeap.size() + 1) {
            largeHeap.add(smallHeap.poll());
        } 
        if(largeHeap.size() > smallHeap.size() + 1) {
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        int totalLen = smallHeap.size() + largeHeap.size();
        if(totalLen % 2 == 1) {
            if(smallHeap.size() > largeHeap.size()) {
                return (double) smallHeap.peek();
            } else {
                return (double) largeHeap.peek();
            }
        } else {
            return ((double)smallHeap.peek() + largeHeap.peek()) /2.0;
        }
    }
}
