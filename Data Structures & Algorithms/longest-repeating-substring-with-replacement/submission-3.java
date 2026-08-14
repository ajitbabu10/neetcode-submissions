class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int maxFreq = 0;
        int ans =0;

        int[] count = new int[26]; 
        for(int r=0;r<s.length();r++) {
            Character c = s.charAt(r);
            count[c - 'A']++;
            maxFreq = Arrays.stream(count).max().getAsInt();
            //maxFreq = Math.max(maxFreq, count[c-'A']);

            // FORMULA: windowSize - maxFreq > k
            while( (r-l+1) - maxFreq > k ) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}