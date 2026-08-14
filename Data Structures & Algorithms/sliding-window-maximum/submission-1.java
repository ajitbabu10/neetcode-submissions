class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k>nums.length) return new int[]{};

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int l=0;
        int r=k-1;
        for(int i=l;i<=r;i++) {
            maxHeap.add(new int[]{nums[i],i});
        }
        List<Integer> list = new ArrayList<>();
        list.add(maxHeap.peek()[0]);
        r++;
        l++;
        while(r<nums.length) {
            maxHeap.add(new int[]{nums[r], r});
            while(! (maxHeap.peek()[1] <= r && maxHeap.peek()[1] >= l)) {
                maxHeap.poll();
            }
            list.add(maxHeap.peek()[0]);
            l++;
            r++;
        }

        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
