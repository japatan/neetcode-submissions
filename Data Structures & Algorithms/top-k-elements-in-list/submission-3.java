class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // int[] freq = new int[nums.length + 1];   // won't work
        Map<Integer, Integer> map = new HashMap<>(); 
        List<List<Integer>> freq = new ArrayList<>(); // instantiates bucket sort
        
        for (int i = 0; i <= nums.length; i++) { // handle the case for when a number's frequency is 0 or equal to the max length
            // create an array for each index
            freq.add(new ArrayList<>());
        }

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Step 3: For each number and its frequency in the map, add the number to freq
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { // or can write `for(var entry : map.entrySet())`
            freq.get(entry.getValue()).add(entry.getKey()); // entry = (number, occurrences)
            // getValue() to get the number of occurrence used as index in freq, and add the key (number) to the array
        }

        // Step 4: Initialize an empty result list.
        int[] res = new int[k];
        int index = 0; // index for res

        for (int i = freq.size() - 1; i >= 0 && index < k; i--) {
            if (!(freq.get(i).isEmpty())) {
                for (int num : freq.get(i)) {
                    res[index++] = num;
                    
                }
            }
            if (index == k) break;
        }
        
        return res;
    }
}
