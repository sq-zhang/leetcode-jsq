/*
 * @lc app=leetcode.cn id=352 lang=java
 *
 * [352] 将数据流变为多个不相交区间
 *
 * https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/description/
 *
 * algorithms
 * Hard (50.44%)
 * Likes:    20
 * Dislikes: 0
 * Total Accepted:    1.2K
 * Total Submissions: 2.4K
 * Testcase Example:  '["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals"]\n[[],[1],[],[3],[],[7],[],[2],[],[6],[]]'
 *
 * 给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
 * 
 * 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
 * 
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * 
 * 
 * 
 * 
 * 进阶：
 * 如果有很多合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 * 
 * 提示：
 * 特别感谢 @yunhong 提供了本问题和其测试用例。
 * 
 */

// @lc code=start
class SummaryRanges {

    Set<Integer> nums;
    LinkedList<int[]> intervals;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        nums = new HashSet<>();
        intervals = new LinkedList<>();
    }
    
    public void addNum(int val) {
        if (nums.contains(val)) {
            return;
        }
        int pos = 0;
        while(pos < intervals.size() && intervals.get(pos)[0] < val) {
            pos++;
        }
        if (nums.contains(val - 1) && nums.contains(val + 1)) {
			intervals.get(pos - 1)[1] = intervals.get(pos)[1];
			intervals.remove(pos);
		} else if (nums.contains(val - 1)) {
			intervals.get(pos - 1)[1]++;
		} else if (nums.contains(val + 1)) {
			intervals.get(pos)[0]--;
		} else {
			intervals.add(pos, new int[] { val, val });
		}

        nums.add(val);
    }
    
    public int[][] getIntervals() {
        return intervals.toArray(new int[0][0]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
// @lc code=end

