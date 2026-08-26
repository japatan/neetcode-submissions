class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0; // later add 1 in the return
        int end = numbers.length - 1;

        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                return new int[]{start + 1, end + 1}; // return indeces, not values
            }
        }
        return new int[]{};
    }
}
