/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */
class Solution {
    public String countAndSay(int n) {
        StringBuilder next = new StringBuilder("1");
        StringBuilder last;
        int count;
        char lastChar;
        while(n > 1) {
            last = next;
            next = new StringBuilder();
            count = 1;
            lastChar = last.charAt(0);
            for(int i = 1;i < last.length();i++) {
                if (last.charAt(i) != lastChar) {
                    next.append(count).append(lastChar);
                    count = 1;
                    lastChar = last.charAt(i);
                } else {
                    count++;
                }
            }
            next.append(count).append(lastChar);
            n--;
        }
        return next.toString();
    }
}

