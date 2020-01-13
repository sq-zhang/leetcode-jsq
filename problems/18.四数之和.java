/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode-cn.com/problems/4sum/description/
 *
 * algorithms
 * Medium (36.27%)
 * Likes:    357
 * Dislikes: 0
 * Total Accepted:    48.1K
 * Total Submissions: 131.8K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 
 * 满足要求的四元组集合为：
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums,int target){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return res;
        }

        Arrays.sort(nums);

        int n = nums.length;
        for(int k = 0;k < n - 3;k++){
            if(k > 0 && nums[k] == nums[k - 1]){
                continue;
            }

            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if(min1 > target){
                break;
            }

            int max1 = nums[k] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if(max1 < target){
                continue;
            }
            
            for(int i = k + 1;i < n - 2;i++){
                if(i > k + 1 && nums[i] == nums[i - 1]){
                    continue;
                }
                int j = i + 1, h = n - 1;
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if(min > target){
                    continue;
                }
                
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if(max < target){
                    continue;
                }

                while (j < h){
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if(curr == target){
                        res.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j < h && nums[j] == nums[j - 1]){
                            j++;
                        }
                        h--;
                        while(j < h && i < h && nums[h] == nums[h + 1]){
                            h--;
                        }
                    } else if (curr > target){
                        h--;
                    } else {
                       j++;
                    }
                }
            }
        }
        return res;
    }

}
// @lc code=end

