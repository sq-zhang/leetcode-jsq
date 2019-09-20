import java.util.Map;

/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) :
            myPow(x * x, n / 2) * x;

    }
}

