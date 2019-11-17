package cn.tenbit.algorithms.leetcode;

import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 寻找两个有序数组的中位数
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0004 {

    public static void main(String[] args) {
        double mid = new Solution1().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        HawConsoles.jsout(mid);
    }

    /**
     * 执行用时：3ms,在所有java提交中击败了99.20%的用户
     * 内存消耗：47.4MB,在所有java提交中击败了93.06%的用户
     */
    private static class Solution1 {

        /**
         * 对两个数组进行伪重组，找出中位数即可
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int xlen = len1 + len2;
            int xdiv = xlen / 2;
            int xmod = xlen % 2;
            int xidx1 = xmod == 0 ? xdiv - 1 : xdiv;
            int xidx2 = xdiv;
            int idx1 = 0;
            int idx2 = 0;
            int xval1 = 0;
            int xval2 = 0;
            boolean bval1;
            boolean bval2;
            int val1;
            int val2;
            int tval;
            for (int xidx = 0; xidx <= xidx2; xidx++) {
                bval1 = idx1 < len1;
                bval2 = idx2 < len2;
                val1 = bval1 ? nums1[idx1] : -1;
                val2 = bval2 ? nums2[idx2] : -1;
                tval = 0;
                if (bval1 && bval2) {
                    if (val1 < val2) {
                        idx1++;
                        tval = val1;
                    } else {
                        idx2++;
                        tval = val2;
                    }
                } else if (bval1) {
                    idx1++;
                    tval = val1;
                } else if (bval2) {
                    idx2++;
                    tval = val2;
                }
                if (xidx == xidx1) {
                    xval1 = tval;
                }
                if (xidx == xidx2) {
                    xval2 = tval;
                }
            }
            //return new BigDecimal(xval1 + xval2).divide(new BigDecimal(2.0), 2, RoundingMode.HALF_UP).doubleValue();
            return (xval1 + xval2) / 2.0;
        }

    }
}
