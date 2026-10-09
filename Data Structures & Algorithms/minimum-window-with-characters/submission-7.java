class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) return "";
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0;               // character counter
        int need = countT.size();   // characters we need to match
        int[] res = {-1, -1};       // default value
        int resLen = Integer.MAX_VALUE; // default value comparison since we want the shortest string for result

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // we use .equals() for the first check of the first iteration
            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            // update string result
            while (have == need) {
                // calculate size of current window
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1; // length of res
                    res[0] = l;         // the index of string res
                    res[1] = r;
                }

                // pop from left of window
                char leftChar = s.charAt(l); // remove one copy of it from our window's count
                window.put(leftChar, window.get(leftChar) - 1);
                // if this char is in t AND we now have fewer than t needs,
                // the window is no longer valid, so one requirement is unmet
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--; // this breaks the while loop (have != need)
                }
                l++;
            }
        }

        // resLen never changed means no valid window was ever found, so return ""
        // otherwise return the best window; +1 because substring's end index is exclusive
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
