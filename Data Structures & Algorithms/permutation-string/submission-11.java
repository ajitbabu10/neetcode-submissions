class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //O(26N) solution
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i=0;i<n1;i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        int l=0;
        for(int r = n1 ; r < n2 ; r++) {
            if(Arrays.toString(count1).equals(Arrays.toString(count2)))
                return true;

            //adding right element
            int index = s2.charAt(r) - 'a';
            count2[index]++;
            
            //removing left element
            index = s2.charAt(l) - 'a';
            count2[index]--;

            l++;
            
        }

        if(Arrays.toString(count1).equals(Arrays.toString(count2)))
                return true;
        else 
            return false;
    }
}
