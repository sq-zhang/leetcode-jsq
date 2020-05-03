/*
 * @lc app=leetcode.cn id=1138 lang=java
 *
 * [1138] 字母板上的路径
 *
 * https://leetcode-cn.com/problems/alphabet-board-path/description/
 *
 * algorithms
 * Medium (36.50%)
 * Likes:    12
 * Dislikes: 0
 * Total Accepted:    3.1K
 * Total Submissions: 7.9K
 * Testcase Example:  '"leet"'
 *
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 * 
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
 * 
 * 
 * 
 * 我们可以按下面的指令规则行动：
 * 
 * 
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * 
 * 
 * （注意，字母板上只存在有字母的位置。）
 * 
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * 
 * 
 * 示例 2：
 * 
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= target.length <= 100
 * target 仅含有小写英文字母。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;
        for(char c : target.toCharArray()) {
            int a = c - 'a';
            int nx = a / 5, ny = a % 5;
            if (c == 'z') {
                while(y > ny) {
                    sb.append("L");
                    y--;
                }
                while(x < nx) {
                    sb.append("D");
                    x++;
                }
            } else {
                while(x < nx) {
                    sb.append("D");
                    x++;
                }
                while(x > nx) {
                    sb.append("U");
                    x--;
                }
                while(y < ny) {
                    sb.append("R");
                    y++;
                }
                while(y > ny) {
                    sb.append("L");
                    y--;
                }
            }
            sb.append("!");
        }
        return sb.toString();
    }
}
// @lc code=end

