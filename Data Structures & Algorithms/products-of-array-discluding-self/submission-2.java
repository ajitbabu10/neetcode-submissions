class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        int prefProd = 1;
        for(int i=0;i<nums.length;i++) {
            ans[i] = prefProd;
            prefProd = prefProd * nums[i];
        }

        int suffProd = 1;
        for(int i=nums.length-1 ; i>=0 ; i--) {
            ans[i] = ans[i] * suffProd;
            suffProd = suffProd * nums[i];
        }


        return ans;
    }
}  
