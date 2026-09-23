class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(0, target, nums, curr);
        return res;
    }

    public void dfs(int index, int target, int[] nums, List<Integer> curr) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if(index == nums.length || target < 0) {
            return;
        }
        curr.add(nums[index]);
        dfs(index, target-nums[index], nums, curr);
        curr.removeLast();
        dfs(index+1, target, nums, curr);
    }
}
