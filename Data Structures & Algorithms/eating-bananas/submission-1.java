class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int elt : piles) {
            max = Math.max(max, elt);
        }

        int l=1;
        int r=max;
        int ans = -1;

        while(l<=r) {
            int mid = l+(r-l)/2;
            if(isPossible(mid, piles, h)) {
                ans = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return ans;

    }

    public static boolean isPossible(int mid, int[] arr, int h) {
        int hours = 0;
        for(int elt : arr) {
            if(elt%mid != 0) {
                hours += elt / mid + 1;
            } else {
                hours += elt / mid;
            }

            // without this line, larger integers will fail since integer overflow will happen when mid = 1
            if(hours > h) 
                return false; 
        }
        if(hours <= h) 
            return true;

        return false;
    }
}
