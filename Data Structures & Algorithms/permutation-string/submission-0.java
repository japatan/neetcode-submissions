class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // if (s1.length() < s2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        int need = map1.size();

        for (int i = 0; i < s2.length(); i++) { // window size starting index
            Map<Character, Integer> map2 = new HashMap<>();
            int cur = 0;
            for (int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j); // iterate through s2
                map2.put(c, map2.getOrDefault(c, 0) + 1);

                if (map1.getOrDefault(c, 0) < map2.get(c)) { // checks for first occurrence
                    break;
                }

                if (map1.getOrDefault(c, 0) == map2.get(c)) {
                    cur++;
                }

                if (need == cur) {
                    return true;
                }
            }
        }
        return false;
    }
}
