class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                // Create an array of 26 integers.
                // Each index represents a letter:
                // 0 = 'a', 1 = 'b', 2 = 'c', ..., 25 = 'z'
                //
                // Example:
                // "eat" → [1,0,0,0,1,0,...,1,...]
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
