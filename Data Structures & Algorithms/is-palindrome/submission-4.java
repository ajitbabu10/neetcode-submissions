class Solution {
    public boolean isPalindrome(String s1) {
        int i=0;
        int j=s1.length()-1;
        //String s1 = s.toLowerCase();
        while(i<=j) {
            char left = Character.toLowerCase(s1.charAt(i));
            char right = Character.toLowerCase(s1.charAt(j));
            if(!Character.isLetterOrDigit(left) || !Character.isLetterOrDigit(right)) {
                if(!Character.isLetterOrDigit(left)) {
                    i++;
                }
                if(!Character.isLetterOrDigit(right)) {
                    j--;
                }
                continue;
            }
            
            if(left != right){
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
