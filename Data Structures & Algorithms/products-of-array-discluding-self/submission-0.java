class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Initiate array size
        int n = nums.length;
        // int[] res = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];

        // Set
        prefix[0] = 1;
        suffix[n - 1] = 1;
        // Prefix items
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        // Suffix items
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        // Output
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}  
