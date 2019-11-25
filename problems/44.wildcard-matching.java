/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        
        if(p.charAt(0) == '*') {
            return isMatch(s, p.substring(1)) || (!s.isEmpty() && isMatch(s.substring(1), p));
        } else {
            boolean match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) 
            || p.charAt(0) == '?');
            return match && isMatch(s.substring(1), p.substring(1));
        }
    }
}

