import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>(Arrays.asList(""));
        for(char c : digits.toCharArray()) {
            List<String> newList = new ArrayList<>();
            char[] letters = getLetters(c).toCharArray();
            for(String str : res) {
                for(char letter : letters) {
                    newList.add(str + letter);
                }
            }
            res = newList;
        }
        return res;
    }

    private String getLetters(char c) {
        switch(c) {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default: return "";
        }
    }
}

