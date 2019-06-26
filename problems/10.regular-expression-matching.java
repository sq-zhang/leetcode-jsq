/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        boolean match = !s.isEmpty() && 
        (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return match && isMatch(s.substring(1), p) || 
            isMatch(s, p.substring(2));
        } else {
            return match && isMatch(s.substring(1), p.substring(1));
        }
    }
}

