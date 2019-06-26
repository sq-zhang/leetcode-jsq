import java.util.Arrays;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        if (4 * nums[0] > target || 4 * max < target) {
            return res;
        }
        
        for(int i = 0;i < nums.length - 3;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + 3 * max < target) {
                continue;
            }
            if (4 * nums[i] > target) {
                break;
            }
            if (4 * nums[i] == target) {
				if (i + 3 < nums.length && nums[i + 3] == nums[i])
					res.add(Arrays.asList(nums[i], nums[i], nums[i], nums[i]));
				break;
			}
            
            for (int j = i + 1;j < nums.length - 2;j++) {
                int l = j + 1, h = nums.length - 1;
                while (l < h) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[h];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[h]));
                        while(l < h && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while(l < h && nums[h] == nums[h - 1]) {
                            h--;
                        }
                        l++;
                        h--;
                    } else if (sum > target) {
                        h--;
                    } else {
                        l++;
                    }
                }
                while(j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
        }
        return res;
    }
}

