import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public void backtrace(List<List<Integer>> res, List<Integer> list, int[] candidates, int start, int remain) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for(int i = start;i < candidates.length;i++) {
                list.add(candidates[i]);
                backtrace(res, list, candidates, i, remain - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}

