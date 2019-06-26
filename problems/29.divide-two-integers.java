/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */
class Solution {
    public int divide(int dividend, int divisor) {
        int flag = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;
        long ldividen = Math.abs(Long.valueOf(dividend));
        long ldivisor = Math.abs(Long.valueOf(divisor));

        long res = ldivide(ldividen, ldivisor);
        
        res = res * flag;
        if (res >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)res;
    }

    public long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) {
            return 0;
        }
        long sum = ldivisor, res = 1;
        while((sum + sum) < ldividend) {
            sum += sum;
            res += res;
        }
        return res + ldivide(ldividend - sum, ldivisor);
    }
}

