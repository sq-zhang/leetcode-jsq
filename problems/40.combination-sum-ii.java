/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                backtrace(res, list, candidates, i + 1, remain - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}

