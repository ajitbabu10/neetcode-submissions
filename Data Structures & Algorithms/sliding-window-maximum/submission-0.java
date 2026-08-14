class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k>nums.length) return new int[]{};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        int l=0;
        int r=k-1;
        for(int i=l;i<=r;i++) {
            maxHeap.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        list.add(maxHeap.peek());
        while(r<nums.length) {
            
            maxHeap.remove(nums[l]);
            l++;
            
            r++;
            if(r<nums.length) {
                maxHeap.add(nums[r]);
                list.add(maxHeap.peek());
            }
                
            
        }

        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
