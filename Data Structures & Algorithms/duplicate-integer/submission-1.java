class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums); // to put the same numbers next to each other
        for (int i = 1; i < nums.length; i++) {
            // continue;
            if (nums[i - 1] == nums[i]) return true;
        }
        return false;
    }
}