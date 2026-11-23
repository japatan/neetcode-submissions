class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
                Map<String, List<String>> map = new HashMap<>();
                        for (String s : strs) {
                                    int[] group = new int[26];
                                                for (char c : s.toCharArray()) {
                                                                group[c - 'a']++;
                                                                            }
                                                                                        String key = Arrays.toString(group);
                                                                                                    map.putIfAbsent(key, new ArrayList());
                                                                                                                // map.put(key, map.get(key).add(s));
                                                                                                                            map.get(key).add(s);
                                                                                                                                    }
                                                                                                                                            return new ArrayList<>(map.values());
                                                                                                                                                }
                                                                                                                                                }
                                                                                                                                                
