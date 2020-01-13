package cn.tenbit.algorithms.leetcode;

import cn.tenbit.algorithms.util.HawUtils;
import cn.tenbit.haw.core.support.HawExecutor;
import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 删除排序数组中的重复项
 * <p>
 * 数组
 * 双指针
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0026 {

    public static void main(String[] args) {
        HawUtils.invokeWithStatistics(new HawExecutor() {
            @Override
            public Object execute() throws Throwable {
                test1();
                return null;
            }
        });
    }

    private static void test1() {
        int[] nums = {1, 1, 2, 2, 3};
        int res = new Solution1().removeDuplicates(nums);
        HawConsoles.jsout(res, nums);
    }

    /**
     * 执行用时：1ms,在所有Java提交中击败了100.00%的用户
     * 内存消耗：40.3MB,在所有Java提交中击败了94.58%的用户
     */
    private static class Solution1 {

        /**
         * 双指针
         */
        public int removeDuplicates(int[] nums) {
            int len = nums.length;
            int cur = 0;
            for (int i = 0; i < len; i++) {
                if (nums[cur] != nums[i]) {
                    nums[++cur] = nums[i];
                }
            }
            return cur + 1;
        }
    }
}
