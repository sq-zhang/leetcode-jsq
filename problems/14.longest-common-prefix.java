/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int i = 0;
        while(true) {
            char last;
            if (i < strs[0].length()) {
                last = strs[0].charAt(i);
            } else {
                return strs[0].substring(0, i);
            }
            for(String s : strs) {
                if (i >= s.length() || s.charAt(i) != last) {
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
    }
}

