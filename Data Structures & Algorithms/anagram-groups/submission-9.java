class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // List<List<String>> freq = new ArrayList<>();

        for (String s : strs) {
            int[] arr = new int[26];
            for (Character c : s.toCharArray()) {
                arr[c - 'a']++;
            }
            String key = Arrays.toString(arr);
            map.putIfAbsent(key, new ArrayList());
            // map.put(key, map.add(s));
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
