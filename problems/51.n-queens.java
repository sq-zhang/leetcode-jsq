import java.util.Arrays;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrace(result, new ArrayList<>(), new boolean[n], new boolean[2 * n], 
            new boolean[2 * n], 0, n);
        return result;
    }

    public void backtrace(List<List<String>> result, List<String> list, boolean[] cols, 
        boolean[] d1, boolean d2[], int idx, int n) {
        if (idx == n) {
            result.add(new ArrayList<>(list));
        } else {
            for(int i = 0;i < n;i++) {
                int idx1 = idx - i + n;
                int idx2 = idx + i;
                if(!cols[i] && !d1[idx1] && !d2[idx2]) {
                    char[] row = new char[n];
                    Arrays.fill(row, '.');
                    row[i] = 'Q';
                    list.add(new String(row));
                    cols[i] = true;
                    d1[idx1] = true;
                    d2[idx2] = true;
                    backtrace(result, list, cols, d1, d2, idx + 1, n);
                    list.remove(list.size() - 1);
                    cols[i] = false;
                    d1[idx1] = false;
                    d2[idx2] = false;
                }
            }
        }
    }
}

