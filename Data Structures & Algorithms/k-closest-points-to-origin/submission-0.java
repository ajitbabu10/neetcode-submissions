class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->
            Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1])
        ); // No need to take root for distance
 
        for(int[] point : points) {
            maxHeap.add(point);
            if(maxHeap.size()>k) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[k][];
        int i=0;
        while(!maxHeap.isEmpty()) {
            ans[i++] = maxHeap.poll();
        }
        return ans;

    }
}
