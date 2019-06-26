import java.util.Map;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */
class Solution {
    public int romanToInt(String s) {
        int romanMap[] = new int[32];
        romanMap['I' - 'A'] = 1;
        romanMap['V' - 'A'] = 5;
        romanMap['X' - 'A'] = 10;
        romanMap['L' - 'A'] = 50;
        romanMap['C' - 'A'] = 100;
        romanMap['D' - 'A'] = 500;
        romanMap['M' - 'A'] = 1000;
        int r = 0;
        char last = 'A';
        for(char c : s.toCharArray()) {
            if (romanMap[c - 'A'] > romanMap[last - 'A']) {
                r -= 2 * romanMap[last - 'A'];
            }
            r += romanMap[c - 'A'];
            last = c;
        }
        return r;
    }
}

