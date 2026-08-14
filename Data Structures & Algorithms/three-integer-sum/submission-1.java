class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++) {
            if(i!=0 && nums[i-1]==nums[i])
                continue;
            int target = 0 - nums[i];
            int start = i+1;
            int end = nums.length-1;
            
            while(start < end) {
                int sum = nums[start] + nums[end];
                if(target == sum) {
                    List<Integer> subAns = new ArrayList<>();
                    subAns.add(nums[i]);
                    subAns.add(nums[start]);
                    subAns.add(nums[end]);
                    ans.add(subAns);
                    start++;
                    end--;
                    while(start < end && nums[start] == nums[start-1]) {
                        start++;
                    }
                } else if(target > sum) {
                    start++;
                } else {
                    end--;
                }
            }

        }
        return ans;

    }
}
