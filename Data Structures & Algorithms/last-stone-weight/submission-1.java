class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int wt : stones) {
            maxHeap.add(wt);
        }

        while(maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();

            if(a == b) {
                continue;
            }
            int toAdd = Math.abs(a-b);
            maxHeap.add(toAdd);
        }
        if(maxHeap.isEmpty()) 
            return 0;
        return maxHeap.peek();
    }
}
