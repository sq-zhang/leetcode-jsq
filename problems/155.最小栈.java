/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (50.62%)
 * Likes:    336
 * Dislikes: 0
 * Total Accepted:    59.7K
 * Total Submissions: 117.9K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 
 * 
 * 示例:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 */

// @lc code=start
class MinStack {

    private Stack<Integer> dataStack;

    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        dataStack.add(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.add(x);
        } else {
            minStack.add(minStack.peek());
        }
    }
    
    public void pop() {
        if (!dataStack.isEmpty()) {
            dataStack.pop();
            minStack.pop();
        }
    }
    
    public int top() {
        if (!dataStack.isEmpty()) {
            return dataStack.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

