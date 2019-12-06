package cn.tenbit.algorithms.leetcode;

import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 罗马数字转整数
 * <p>
 * 数学
 * 字符串
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0012 {

    public static void main(String[] args) {
        String str = "MCMXCIV";

        int roman = new Solution1().romanToInt(str);
        HawConsoles.jsout(roman);
    }

    /**
     * 执行用时：6ms,在所有java提交中击败了82.94%的用户
     * 内存消耗：35.9MB,在所有java提交中击败了99.56%的用户
     */
    private static class Solution1 {

        /**
         *
         */
        public int romanToInt(String s) {
            char[] chs = s.toCharArray();
            int len = chs.length;
            int res = 0;
            for (int idx = 0; idx < len; idx++) {
                char ch1 = chs[idx];
                char ch2 = idx + 1 < len ? chs[idx + 1] : 0;
                boolean spe = ch2 != 0 && tag(ch1) < tag(ch2);
                if (spe) {
                    res += spe(ch1, ch2);
                    idx++;
                } else {
                    res += cv(ch1);
                }
            }
            return res;
        }

        private int spe(char ch1, char ch2) {
            if (ch1 == 'I') {
                if (ch2 == 'V') {
                    return 4;
                } else if (ch2 == 'X') {
                    return 9;
                }
            } else if (ch1 == 'X') {
                if (ch2 == 'L') {
                    return 40;
                } else if (ch2 == 'C') {
                    return 90;
                }
            } else if (ch1 == 'C') {
                if (ch2 == 'D') {
                    return 400;
                } else if (ch2 == 'M') {
                    return 900;
                }
            }
            return 0;
        }

        private int cv(char ch) {
            int cv = 0;
            switch (ch) {
                case 'M':
                    cv = 1000;
                    break;
                case 'D':
                    cv = 500;
                    break;
                case 'C':
                    cv = 100;
                    break;
                case 'L':
                    cv = 50;
                    break;
                case 'X':
                    cv = 10;
                    break;
                case 'V':
                    cv = 5;
                    break;
                case 'I':
                    cv = 1;
                    break;
            }
            return cv;
        }

        private int tag(char ch) {
            int cv = 0;
            switch (ch) {
                case 'M':
                    cv = 7;
                    break;
                case 'D':
                    cv = 6;
                    break;
                case 'C':
                    cv = 5;
                    break;
                case 'L':
                    cv = 4;
                    break;
                case 'X':
                    cv = 3;
                    break;
                case 'V':
                    cv = 2;
                    break;
                case 'I':
                    cv = 1;
                    break;
            }
            return cv;
        }
    }
}
