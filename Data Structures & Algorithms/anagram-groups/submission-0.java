class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Set<Integer> alreadyPut = new HashSet<>();
        for(int i=0;i<strs.length;i++) {
            List<String> subAnswer = new ArrayList<>();
            if(!alreadyPut.contains(i)) {
                subAnswer.add(strs[i]);
                for(int j=i+1; j<strs.length;j++) {
                    if(isAnagram(strs[i], strs[j]) && !alreadyPut.contains(j)) {
                        subAnswer.add(strs[j]);
                        alreadyPut.add(j);
                    }
                }
                ans.add(subAnswer);
            } 
        }
        return ans;
    }

    public boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) 
            return false;
        int[] count = new int[26];
        for(int i=0;i<s1.length();i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for(int val : count){
            if(val != 0)
                return false;
        }
        return true;
    }
}
