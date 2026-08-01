class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complement = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int difference = target - nums[i];
            if (complement.containsKey(difference)){
                // return [complement.getValue(), i];
                return new int[]{complement.get(difference), i};
            }
            complement.put(nums[i], i);
        }
        return null;
    }
}
