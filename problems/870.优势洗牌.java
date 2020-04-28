/*
 * @lc app=leetcode.cn id=870 lang=java
 *
 * [870] 优势洗牌
 *
 * https://leetcode-cn.com/problems/advantage-shuffle/description/
 *
 * algorithms
 * Medium (33.60%)
 * Likes:    54
 * Dislikes: 0
 * Total Accepted:    6.3K
 * Total Submissions: 16.7K
 * Testcase Example:  '[2,7,11,15]\n[1,10,4,11]'
 *
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * 
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 
 * 
 * 示例 2：
 * 
 * 输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n], visited = new int[n];
        Arrays.sort(A);
        Arrays.fill(res, -1);
        for(int i = 0;i < n;i++) {
            int l = 0, r = n - 1;
            while(l <= r) {
                int mid = (l + r) / 2;
                if (A[mid] <= B[i]) {
                    l = mid + 1;
                } else if (mid == 0 || A[mid - 1] <= B[i]) {
                    while(mid < n && visited[mid] == 1) {
                        mid++;
                    }
                    if (mid < n) {
                        res[i] = A[mid];
                        visited[mid] = 1;
                    }
                    break;
                } else {
                    r = mid;
                }
            }
        }
        for(int j = 0, k = 0;j < n;j++) {
            if (res[j] == -1) {
                while(k < n && visited[k] == 1) {
                    k++;
                }
                if (k < n) {
                    res[j] = A[k];
                    visited[k] = 1;
                }
            }
        }
        return res;
    }
}
// @lc code=end

