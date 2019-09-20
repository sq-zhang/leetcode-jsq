import java.util.ArrayList;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(result, new ArrayList<>(), nums);
        return result;
    }

    public void backtrace(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for(int i = 0;i < nums.length;i++) {
                if(list.contains(nums[i])) {
                    continue;
                }
                list.add(nums[i]);
                backtrace(result, list, nums);
                list.remove(list.size() - 1);
            }
        }

    }
}

