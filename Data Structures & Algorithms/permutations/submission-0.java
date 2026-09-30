class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] contains = new boolean[nums.length];
        recurPermute(nums, curr, contains);
        return res;
    }

    public void recurPermute(int[] nums, List<Integer> curr, boolean[] contains) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(!contains[i]) {
                contains[i] = true;
                curr.add(nums[i]);
                recurPermute(nums, curr, contains);
                curr.removeLast();
                contains[i] = false;
            }
        }
    }
}
