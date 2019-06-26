/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int y = x, r = 0;
        while(y > 0) {
            r = r * 10 + y % 10;
            y /= 10;
        }
        return r == x;
    }
}

