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

        for(int i = index; i < nums.length ; i++) {
            if(i > index && nums[i] == nums[i-1])
                continue;
            
            if(nums[i] > target) {
                break;
            }
            curr.add(nums[i]);
            dfs(i+1, target - nums[i], nums, curr);
            curr.remove(curr.size()-1);

            
        }
    }
}
