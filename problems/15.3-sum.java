import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 2;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, h = nums.length - 1, target = 0 - nums[i];
            while(l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    while (l < h && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (h > l && nums[h] == nums[h - 1]) {
                        h--;
                    }
                    l++;
                    h--;
                } else if (sum < 0) {
                    l++;
                } else {
                    h--;
                }
            }
        }
        return res;
    }
}

