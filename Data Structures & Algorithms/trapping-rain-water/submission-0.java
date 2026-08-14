class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        int lMax = 0;
        leftMax[0] = 0; 
        for(int i=1;i<height.length;i++) {
            lMax = Math.max(lMax, height[i-1]);
            leftMax[i] = lMax;
        }

        int rMax = 0;
        rightMax[height.length - 1] = 0;
        for(int i=height.length - 2;i>=0;i--) {
            rMax = Math.max(rMax, height[i+1]);
            rightMax[i] = rMax;
        }

        int ans=0;
        for(int i=0;i<height.length;i++) {
            ans += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0 );
        }
        return ans;
    }
}
