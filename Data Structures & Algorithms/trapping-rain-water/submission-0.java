class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int l = 0;
        int r = height.length - 1;

        int lMax = height[l];
        int rMax = height[r];

        int res = 0;

        while (l < r) {
            if (lMax < rMax) {
                l++;
                lMax = Math.max(height[l], lMax);
                res += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(height[r], rMax);
                res += rMax - height[r];
            }

        }
        return res;
    }
}
