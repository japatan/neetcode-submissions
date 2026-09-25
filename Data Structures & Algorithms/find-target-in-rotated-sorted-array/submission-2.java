class Solution {
    public int search(int[] nums, int target) {
        if (target == nums[0]) return 0;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                return m;
            } 

            if (nums[l] <= nums[m]) { // sorted left array
                if (target < nums[l] || target > nums[m] ) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }

            } else { // sorted right array
                if (target > nums[r] || target < nums[m] ) {
                    r = m - 1;
                } else  {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
