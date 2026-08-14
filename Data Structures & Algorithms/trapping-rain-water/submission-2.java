class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;

        int l=0;
        int r=n-1;
        int lMax = height[l];
        int rMax = height[r];

        int ans=0;
        
        // while(l < r) {
        //     if(lMax <= rMax) {
        //         ans += lMax - height[l];
        //         l++;
        //         lMax = Math.max(lMax, height[l]);
                
        //     } else {
        //         ans += rMax - height[r];
        //         r--;
        //         rMax = Math.max(rMax, height[r]);
        //     }
        // }

        while(l < r) {
            if(lMax <= rMax) {
                l++;
                ans += Math.max(lMax - height[l], 0);
                lMax = Math.max(lMax, height[l]);
            } else {
                r--;
                ans += Math.max(rMax - height[r], 0);
                rMax = Math.max(rMax, height[r]);
            }
        }
        return ans;
    }
}