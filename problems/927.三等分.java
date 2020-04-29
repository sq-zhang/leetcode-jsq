/*
 * @lc app=leetcode.cn id=927 lang=java
 *
 * [927] 三等分
 *
 * https://leetcode-cn.com/problems/three-equal-parts/description/
 *
 * algorithms
 * Hard (28.56%)
 * Likes:    22
 * Dislikes: 0
 * Total Accepted:    1.3K
 * Total Submissions: 4.2K
 * Testcase Example:  '[1,0,1,0,1]'
 *
 * 给定一个由 0 和 1 组成的数组 A，将数组分成 3 个非空的部分，使得所有这些部分表示相同的二进制值。
 * 
 * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
 * 
 * 
 * A[0], A[1], ..., A[i] 组成第一部分；
 * A[i+1], A[i+2], ..., A[j-1] 作为第二部分；
 * A[j], A[j+1], ..., A[A.length - 1] 是第三部分。
 * 这三个部分所表示的二进制值相等。
 * 
 * 
 * 如果无法做到，就返回 [-1, -1]。
 * 
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以
 * [0,1,1] 和 [1,1] 表示相同的值。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[1,0,1,0,1]
 * 输出：[0,3]
 * 
 * 
 * 示例 2：
 * 
 * 输出：[1,1,0,1,1]
 * 输出：[-1,-1]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 3 <= A.length <= 30000
 * A[i] == 0 或 A[i] == 1
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] threeEqualParts(int[] A) {
        int[] res = new int[]{-1, -1};
        int n = A.length;
        int countOne = 0;
        for(int num : A) {
            countOne += num;
        }
        if (countOne % 3 != 0) {
            return res;
        }
        int part = countOne / 3;
        if (part == 0) {
            return new int[]{0, n - 1};
        }
        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1, count = 0;
        for(int i = 0;i < n;i++) {
            if (A[i] == 1) {
                count++;
                if (count == 1) i1 = i;
                if (count == part)  j1 = i;
                if (count == part + 1)  i2 = i;
                if (count == 2 * part)  j2 = i;
                if (count == 2 * part + 1)  i3 = i;
                if (count == 3 * part)  j3 = i;
            }
        }
        int[] part1 = Arrays.copyOfRange(A, i1, j1 + 1);
        int[] part2 = Arrays.copyOfRange(A, i2, j2 + 1);
        int[] part3 = Arrays.copyOfRange(A, i3, j3 + 1);
        
        if (!Arrays.equals(part1, part2) || !Arrays.equals(part1, part3)) {
            return res;
        }
        
        int x = i2 - j1 -1, y = i3 - j2 - 1, z = n - j3 - 1;
        if (x < z || y < z) {
            return res;
        }
        return new int[]{j1 + z, j2 + z + 1};
    }
}
// @lc code=end

