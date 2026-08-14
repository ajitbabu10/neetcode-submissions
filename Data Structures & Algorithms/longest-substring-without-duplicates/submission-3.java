class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        if(s.length() == 1) return 1;

        int l=0;
        int r=1;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while(r < s.length()) {
            set.add(s.charAt(l));

            if(set.contains(s.charAt(r))) {
                l++;
                r=l+1;
                max = Math.max(max, set.size());
                set.clear();
            } else {
                set.add(s.charAt(r));
                max = Math.max(max, set.size());
                r++;
            }
            
            
        }
        return max;

    }
}
