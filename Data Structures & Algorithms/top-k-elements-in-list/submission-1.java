class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Bucket Sort solution
        Map<Integer, Integer> hmap = new HashMap<>();
        List<Integer>[] list = new List[nums.length+1];
        // Initialize all lists inside list
        for(int i = 0 ; i < list.length ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int num:nums) {
            hmap.put(num, hmap.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry:hmap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            list[value].add(key);
        }

        int[] ans = new int[k];
        int index = 0;

        for(int i = list.length-1 ; i > 0 && index < k ; i--) {
            if(list[i].isEmpty())
                continue;
            else {
                for(Integer num : list[i]) {
                    ans[index] = num;
                    index++;
                }
            }
        }
        return ans;
    }
}
