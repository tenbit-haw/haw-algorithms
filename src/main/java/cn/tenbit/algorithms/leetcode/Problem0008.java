package cn.tenbit.algorithms.leetcode;

import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 字符串转换整数 (atoi)
 * <p>
 * 数学
 * 字符串
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0008 {

    public static void main(String[] args) {
//        int maxValue = Integer.MAX_VALUE;
//        int minValue = Integer.MIN_VALUE;
//        HawConsoles.jsout(maxValue);
//        HawConsoles.jsout(minValue);

        int atoi = new Solution1().myAtoi(" +34  xx  ");
        HawConsoles.jsout(atoi);
    }

    /**
     * 执行用时：2ms,在所有java提交中击败了99.94%的用户
     * 内存消耗：35.9MB,在所有java提交中击败了88.03%的用户
     */
    private static class Solution1 {

        /**
         * 糟糕的if判断
         */
        public int myAtoi(String str) {
            char[] chs = str.toCharArray();
            int cur = 0;
            boolean flg = false;
            boolean sgn = true;
            boolean srt = false;
            long res = 0;
            for (char ch : chs) {
                if (cur == 0) {
                    if (ch == '-') {
                        if (srt || flg) {
                            return 0;
                        }
                        flg = true;
                        continue;
                    }
                    if (ch == '+') {
                        if (srt || flg) {
                            return 0;
                        }
                        flg = true;
                        sgn = false;
                        continue;
                    }
                    if (Character.isWhitespace(ch)) {
                        if (srt || flg) {
                            return 0;
                        }
                        continue;
                    }
                    if (ch < '0' || ch > '9') {
                        return 0;
                    }
                }
                if (ch < '0' || ch > '9') {
                    break;
                }
                srt = true;
                if (!flg) {
                    sgn = false;
                }
                if (cur == 0 && ch == '0') {
                    continue;
                }
                if (cur >= 10) {
                    return sgn ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                cur++;
                res *= 10;
                res += ch - '0';
            }
            if (res > Integer.MAX_VALUE) {
                return sgn ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            return (int) (sgn ? -res : res);
        }
    }
}
