class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int r=heights.length-1;
        int max = 0;
        while(l<r) {
            int lh = heights[l];
            int rh = heights[r];
            int length = Math.min(lh, rh);
            int breadth = r-l;
            int area = length * breadth;
            max = Math.max(max, area);
            if(lh < rh) l++;
            else if(lh > rh) r--;
            else {
                if(heights[l+1] > heights[r-1]) {
                    l++; 
                } else if(heights[l+1] < heights[r-1]) {
                    r--;
                } else {
                    l++;
                    r--;
                }
            }
        }
        return max;
    }
}
