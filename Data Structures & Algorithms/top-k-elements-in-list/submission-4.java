class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> freq = new ArrayList<>();

        // DOES NOT INCLUDE +1 SLOT
        // for (int n : nums) {
        //     freq.add(new ArrayList<>());
        // }

        for (int i = 0; i <= nums.length; i++) {
            freq.add(new ArrayList<>());
        }

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq.get(entry.getValue()).add(entry.getKey());
        }

        int[] res = new int[k];
        int i = 0;
        for (int j = freq.size() - 1; j >= 0 && i < k; j--) {
            // res[i++] = freq.getValue();
            for (int n : freq.get(j)) {
                res[i++] = n;
            }

        }
        return res;
    }
}
