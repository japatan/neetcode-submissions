class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                int right = map.getOrDefault(num + 1, 0);
                int left = map.getOrDefault(num - 1, 0);
                map.put(num, left + right + 1);
                map.put(num - left, map.get(num));
                map.put(num + right, map.get(num));
                res = Math.max(res, map.get(num));
            }
        }
        return res;
    }
}
