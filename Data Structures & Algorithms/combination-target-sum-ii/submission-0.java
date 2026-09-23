class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
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
        dfs(index+1, target - nums[index], nums, curr);
        curr.remove(curr.size()-1);
        while(index+1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        dfs(index+1, target, nums, curr);
    }
}
