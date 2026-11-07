class Solution {

    public String encode(List<String> strs) {
        // if (strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        // Without the early return, encode([]) would skip the loop and return "" anyway, since the StringBuilder is empty.
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = length + i;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
