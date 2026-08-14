class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i=0;i<n1;i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i=0;i<26;i++) {
            if(count1[i] == count2[i]) 
                matches++;
        }

        int l=0;
        for(int r = n1 ; r < n2 ; r++) {
            if(matches == 26) return true;

            //adding right element
            int index = s2.charAt(r) - 'a';
            count2[index]++;
            if(count1[index] == count2[index]) 
                matches++;
            else if(count1[index]+1 == count2[index])
                matches--;

            //removing left element
            index = s2.charAt(l) - 'a';
            count2[index]--;
            if(count1[index] == count2[index])
                matches++;
            else if(count1[index]-1 == count2[index])
                matches--;

            l++;
            
        }

        return matches == 26;
    }
}
