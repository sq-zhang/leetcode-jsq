import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> s = new Stack<>();
        int i = 0, waters = 0;
        while(i < height.length) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) {
                s.push(i++);
            } else {
                int bottom = s.pop();
                waters += s.isEmpty() ? 0 : (Math.min(height[i], 
                    height[s.peek()]) - height[bottom]) * (i - s.peek() - 1);
            }
        }

        return waters;
    }
}

