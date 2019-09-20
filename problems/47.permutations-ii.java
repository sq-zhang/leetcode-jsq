/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;

        

    }

    public void backtrace(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for(int i = 0;i < nums.length;i++) {
                if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                list.add(nums[i]);
                backtrace(result, list, nums, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}

