/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 *
 * https://leetcode-cn.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (50.65%)
 * Likes:    102
 * Dislikes: 0
 * Total Accepted:    9.6K
 * Total Submissions: 18.8K
 * Testcase Example:  '0'
 *
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 
 * 
 * 
 * 例如，上面的二进制手表读取 “3:25”。
 * 
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * 
 * 案例:
 * 
 * 
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16",
 * "0:32"]
 * 
 * 
 * 
 * 注意事项:
 * 
 * 
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        String[][] hstrs = {{"0"}, {"1","2","4","8"}, {"3","5","6","9","10"}, {"7","11"}};
        String[][] mstrs = {{"00"}, {"01","02","04","08","16","32"}, {"03","05","06","09","10","12","17","18","20","24","33","34","36","40","48"}, {"07","11","13","14","19","21","22","25","26","28","35","37","38","41","42","44","49","50","52","56"}, {"15","23","27","29","30","39","43","45","46","51","53","54","57","58"}, {"31","47","55","59"}};

        for(int i = 0; i <= Math.min(3, num); i++) {
            if (num - i > 5) {
                continue;
            }
            String[] hstr = hstrs[i];
            String[] mstr = mstrs[num - i];
            for(int j = 0; j < hstr.length; j++) {
                for(int k = 0; k < mstr.length; k++) {
                    res.add(hstr[j] + ":" + mstr[k]);
                };
            };
        };
        return res;

    }
}
// @lc code=end

