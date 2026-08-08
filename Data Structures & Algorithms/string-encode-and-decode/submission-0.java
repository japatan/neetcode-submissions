class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0) return "";
        // String code = "";
        StringBuilder sb = new StringBuilder(); // better for memory
        for (String str : strs) {
            // code += String.valueOf(str.length()) + "#" + str;
            // code += Integer.toString(str.length()) + "#" + str;
            sb.append(str.length()).append("#").append(str); 
        }
        String encoded = sb.toString();
        return encoded;
    }

    public List<String> decode(String str) {
        if (str.length() == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        // List<Integer> sizes = new ArrayList<>();


        int i = 0; 
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            res.add(str.substring(i, i + length));
            i = i + length;
        }
        
        return res;
    }
}
