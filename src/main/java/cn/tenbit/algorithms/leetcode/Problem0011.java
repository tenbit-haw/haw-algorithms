package cn.tenbit.algorithms.leetcode;

import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 盛最多水的容器
 * <p>
 * 数组
 * 双指针
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0011 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int area1 = new Solution1().maxArea(arr);
        HawConsoles.jsout(area1);

        int area2 = new Solution2().maxArea(arr);
        HawConsoles.jsout(area2);
    }

    /**
     * 执行用时：2ms,在所有java提交中击败了99.87%的用户
     * 内存消耗：39.4MB,在所有java提交中击败了93.66%的用户
     */
    private static class Solution2 {

        /**
         * 双指针法
         * <p>
         * 将矩形底部由最大开始递减，两竖边向内收拢，这样能迅速找出最佳值
         * <p>
         * 有类似贪心思想
         */
        public int maxArea(int[] arr) {
            int len = arr.length;
            int max = 0;
            int ldx = 0;
            int rdx = len - 1;
            int lft = 0;
            int rgt = 0;
            while (ldx < rdx) {
                int hl = arr[ldx];
                int hr = arr[rdx];
                int now = (hl < hr ? hl : hr) * (rdx - ldx);
                if (now > max) {
                    max = now;
                    lft = hl;
                    rgt = hr;
                }
                // 每次保留高的边
                if (hl > hr) {
                    rdx--;
                } else {
                    ldx++;
                }
            }
            // HawConsoles.jsout(lft, rgt);
            return max;
        }
    }

    /**
     * 执行用时：248ms,在所有java提交中击败了33.39%的用户
     * 内存消耗：39.8MB,在所有java提交中击败了92.64%的用户
     */
    private static class Solution1 {

        /**
         * 暴力法
         */
        public int maxArea(int[] arr) {
            int len = arr.length;
            int max = 0;
            int lft = 0;
            int rgt = 0;
            for (int idx = 0; idx < len - 1; idx++) {
                for (int jdx = idx + 1; jdx < len; jdx++) {
                    int hi = arr[idx];
                    int hj = arr[jdx];
                    int now = (hi < hj ? hi : hj) * (jdx - idx);
                    if (now > max) {
                        max = now;
                        lft = hi;
                        rgt = hj;
                    }
                }
            }
            // HawConsoles.jsout(lft, rgt);
            return max;
        }
    }
}
