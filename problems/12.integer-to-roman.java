/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num >= 1000) {
            sb.append("M");
            num -= 1000;
        }
        while (num >= 500) {
            if (num >= 900) {
                sb.append("CM");
                num -= 900;
            } else {
                sb.append("D");
                num -= 500;
            }
        }
        while (num >= 100) {
            if (num >= 400) {
                sb.append("CD");
                num -= 400;
            } else {
                sb.append("C");
                num -= 100;
            }
        }
        while (num >= 50) {
            if (num >= 90) {
                sb.append("XC");
                num -= 90;
            } else {
                sb.append("L");
                num -= 50;
            }
        }
        while (num >= 10) {
            if (num >= 40) {
                sb.append("XL");
                num -= 40;
            } else {
                sb.append("X");
                num -= 10;
            }
        }
        while (num >= 5) {
            if (num >= 9) {
                sb.append("IX");
                num -= 9;
            } else {
                sb.append("V");
                num -= 5;
            }
        }
        while (num > 0) {
            if (num >= 4) {
                sb.append("IV");
                num -= 4;
            } else {
                sb.append("I");
                num -= 1;
            }
        }
        return sb.toString();
    }
}

