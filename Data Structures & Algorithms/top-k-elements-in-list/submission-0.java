class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        // Sort to descending order
        entries.sort((a,b) -> b.getValue() - a.getValue());

        int[] output = new int[k]; // instantiate an array of k-length
        for (int i = 0; i < k; i++) {
            output[i] = entries.get(i).getKey();
        }
        return output;
    }
}
