class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];  // initialise an array of 26 zeros
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>()); // make an array based on unseen keys ONLY
            map.get(key).add(s); // add the string to the associated key
        }
        return new ArrayList<>(map.values());
    }
}
