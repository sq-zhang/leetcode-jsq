import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */
class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        addParenthesis("", 0, 0, n);
        return res;
    }

    public void addParenthesis(String s, int left, int right, int n) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }
        if (left < n) {
            addParenthesis(s + '(', left + 1, right, n);
        }
        if (left > right) {
            addParenthesis(s + ')', left, right + 1, n);
        }
    }
}

