import java.util.ArrayList;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> maps = new HashMap<>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!maps.containsKey(key)) {
                maps.put(key, new ArrayList<>());
            }
            maps.get(key).add(str);
        }
        return new ArrayList<>(maps.values());
    }
}

