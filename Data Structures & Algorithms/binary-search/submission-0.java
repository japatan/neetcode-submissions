class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        // lower bound
        while (l < r) {
            int midIndex = l + (r - l) / 2;
            if (nums[midIndex] >= target) {
                r = midIndex;
            } else {
                l = midIndex + 1;
            }
        }
        return (l < nums.length && nums[l] == target) ? l : -1;
    }
}
