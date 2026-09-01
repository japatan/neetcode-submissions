class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int right = s.length() - 1; 
        Set<Character> substring = new HashSet<>();
        // HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            while (substring.contains(s.charAt(right))) {
                substring.remove(s.charAt(left));
                left++;
            }
            substring.add(s.charAt(right));
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
