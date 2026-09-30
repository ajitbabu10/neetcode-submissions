class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, subset, res);
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        if(index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(nums, index+1, subset, res);
        subset.removeLast();
        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }
        dfs(nums, index+1, subset, res);
    }
}
