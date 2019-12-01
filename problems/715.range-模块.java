/*
 * @lc app=leetcode.cn id=715 lang=java
 *
 * [715] Range 模块
 *
 * https://leetcode-cn.com/problems/range-module/description/
 *
 * algorithms
 * Hard (30.86%)
 * Likes:    19
 * Dislikes: 0
 * Total Accepted:    428
 * Total Submissions: 1.4K
 * Testcase Example:  '["RangeModule","addRange","removeRange","queryRange","queryRange","queryRange"]\n[[],[10,20],[14,16],[10,14],[13,15],[16,17]]'
 *
 * Range 模块是跟踪数字范围的模块。你的任务是以一种有效的方式设计和实现以下接口。
 * 
 * 
 * addRange(int left, int right) 添加半开区间 [left,
 * right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right)
 * 中尚未跟踪的任何数字到该区间中。
 * queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回
 * true。
 * removeRange(int left, int right) 停止跟踪区间 [left, right) 中当前正在跟踪的每个实数。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * addRange(10, 20): null
 * removeRange(14, 16): null
 * queryRange(10, 14): true （区间 [10, 14) 中的每个数都正在被跟踪）
 * queryRange(13, 15): false （未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
 * queryRange(16, 17): true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 半开区间 [left, right) 表示所有满足 left <= x < right 的实数。
 * 对 addRange, queryRange, removeRange 的所有调用中 0 < left < right < 10^9。
 * 在单个测试用例中，对 addRange 的调用总数不超过 1000 次。
 * 在单个测试用例中，对  queryRange 的调用总数不超过 5000 次。
 * 在单个测试用例中，对 removeRange 的调用总数不超过 1000 次。
 * 
 * 
 * 
 * 
 */

// @lc code=start
class RangeModule {

    private TreeSet<Range> ranges;

    public RangeModule() {
        ranges = new TreeSet<>();
    }
    
    public void addRange(int left, int right) {
        Iterator<Range> iterator = ranges.tailSet(new Range(0, left - 1)).iterator();
        while(iterator.hasNext()) {
            Range range = iterator.next();
            if (right < range.getLeft()) {
                break;
            }
            left = Math.min(left, range.getLeft());
            right = Math.max(right, range.getRight());
            iterator.remove();
        }
        ranges.add(new Range(left, right));
    }
    
    public boolean queryRange(int left, int right) {
        Range range = ranges.higher(new Range(0, left));
        return range != null && range.getLeft() <= left && right <= range.getRight();
    }
    
    public void removeRange(int left, int right) {
        Iterator<Range> iterator = ranges.tailSet(new Range(0, left)).iterator();
        List<Range> adds = new ArrayList<>();
        while(iterator.hasNext()) {
            Range range = iterator.next();
            if (right < range.getLeft()) {
                break;
            }
            if (range.getLeft() < left) {
                adds.add(new Range(range.getLeft(), left));
            }
            if (right < range.getRight()) {
                adds.add(new Range(right, range.getRight()));
            }
            iterator.remove();
        }
        for(Range range : adds) {
            ranges.add(range);
        }
    }
}

class Range implements Comparable<Range>{
    private int left;
    private int right;

    public Range(int left, int right){
        this.left = left;
        this.right = right;
    }

    public int compareTo(Range that){
        if (this.right == that.right) {
            return this.left - that.left; 
        }

        return this.right - that.right;
    }

    public int getLeft() {
        return this.left;
    }

    public int getRight() {
        return this.right;
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
// @lc code=end

