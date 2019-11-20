package cn.tenbit.algorithms.leetcode;

import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 整数反转
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0007 {

    public static void main(String[] args) {
        int r = new Solution1().reverse(-123);
        HawConsoles.jsout(r);
    }

    /**
     * 执行用时：1ms,在所有java提交中击败了100.00%的用户
     * 内存消耗：33.6MB,在所有java提交中击败了80.00%的用户
     */
    private static class Solution1 {

        public int reverse(int x) {
            long t = x;
            t = t < 0 ? -t : t;
            long r = 0;
            while (t != 0) {
                r *= 10;
                r += t % 10;
                t /= 10;
            }
            return r > Integer.MAX_VALUE ? 0 : (int) (x < 0 ? -r : r);
        }
    }
}
