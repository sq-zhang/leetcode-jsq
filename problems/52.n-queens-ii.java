/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */
class Solution {

    int nums = 0;

    public int totalNQueens(int n) {
        backtrace(new boolean[n], new boolean[2 * n], new boolean[2 * n], 0, n);
        return nums;
    }

    public void backtrace(boolean[] cols, boolean[] d1, boolean d2[], int idx, int n) {
        if (idx == n) {
            nums++;
        } else {
            for(int i = 0;i < n;i++) {
                int idx1 = idx - i + n;
                int idx2 = idx + i;
                if(!cols[i] && !d1[idx1] && !d2[idx2]) {
                    cols[i] = true;
                    d1[idx1] = true;
                    d2[idx2] = true;
                    backtrace(cols, d1, d2, idx + 1, n);
                    cols[i] = false;
                    d1[idx1] = false;
                    d2[idx2] = false;
                }
            }
        }
    }
}

