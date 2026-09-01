class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))){
                // l = s.charAt(r) + 1; // points to ASCII value

                // +1 to shift an index forward of th old r position, 
                // after getting the value
                // max(..) used to compare on l to prevent going back the index
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
