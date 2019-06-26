import java.util.ArrayList;

/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (32.03%)
 * Likes:    1051
 * Dislikes: 3274
 * Total Accepted:    324.4K
 * Total Submissions: 1M
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0;i < numRows;i++) {
            sb[i] = new StringBuffer();
        }
        int index = 0, flags = 1;
        for(int i = 0;i < s.length();i++) {
            sb[index].append(s.charAt(i));
            if (numRows == 1){
                continue;
            }
            index = index + flags;
            if(index == 0 || index == numRows - 1) {
                flags *= -1;
            }
        }
        for(int i = 1;i < numRows;i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}

