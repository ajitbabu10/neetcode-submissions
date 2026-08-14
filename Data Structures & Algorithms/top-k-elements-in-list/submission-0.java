class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int num:nums) {
            hmap.put(num, hmap.getOrDefault(num, 0)+1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0])); 
        //PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for(int key:hmap.keySet()) {
            int value = hmap.get(key);
            maxHeap.add(new int[]{value, key});
        }

        int ans[] = new int[k];
        for(int i=0;i<k;i++) {
            ans[i] = maxHeap.poll()[1];
        }

        return ans;
    }
}
