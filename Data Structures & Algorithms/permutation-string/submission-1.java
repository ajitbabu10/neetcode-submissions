class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2) return false;

        int l=0;
        int r=n1-1;
        int[] count1 = new int[26];
        int[] count2= new int[26];
        for(int i=0;i<n1;i++) {
            count1[s1.charAt(i) - 'a']++;
        }

        for(int i=l;i<=r;i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        while(r<n2) {
            if(!Arrays.equals(count1, count2)) {
                count2[s2.charAt(l) - 'a']--;
                l++;
                r++;
                if(r<n2)
                    count2[s2.charAt(r) - 'a']++;
            } else {
                return true;
            }
        }
        return false;
    }
}
