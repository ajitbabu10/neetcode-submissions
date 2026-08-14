class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
    
        for(int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for(Integer num : set) {
            if(!set.contains(num-1)) {
                int length = 0;
                while(set.contains(num+length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
