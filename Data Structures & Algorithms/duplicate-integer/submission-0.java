class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int elt:nums) {
            if(set.contains(elt)) {
                return true;
            } else {
                set.add(elt);
            }
        }
        return false;
    }
}