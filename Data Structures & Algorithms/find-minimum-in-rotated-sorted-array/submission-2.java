class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        // int res = 0;
        
        while (l < r) {
            // m is always the left-leaning midpoint (due to floor division). m can equal l but not r
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}
