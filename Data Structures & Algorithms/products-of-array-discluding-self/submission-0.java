class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];

        int prefProd = 1;
        prefixProduct[0] = 1;
        for(int i=0;i<nums.length-1;i++) {
            prefProd = prefProd * nums[i];
            prefixProduct[i+1] = prefProd;
        }

        int suffProd = 1;
        suffixProduct[nums.length-1] = 1;
        for(int i=nums.length - 1;i>0;i--) {
            suffProd = suffProd * nums[i];
            suffixProduct[i-1] = suffProd;
        }

        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            ans[i] = prefixProduct[i] * suffixProduct[i];
        }

        return ans;
    }
}  
