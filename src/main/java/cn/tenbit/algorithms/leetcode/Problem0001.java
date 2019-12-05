package cn.tenbit.algorithms.leetcode;

import cn.tenbit.haw.core.util.HawConsoles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <p>
 * 数组，hash表
 *
 * @author bangquan.qian
 * @date 2019-11-13 19:43
 */
public class Problem0001 {

    public static void main(String[] args) {
        int[] res1 = new Solution1().twoSum(new int[]{2, 7, 11, 15}, 9);
        HawConsoles.jsout(res1);

        int[] res2 = new Solution2().twoSum(new int[]{2, 7, 11, 15}, 9);
        HawConsoles.jsout(res2);

        int[] res3 = new Solution3().twoSum(new int[]{2, 7, 11, 15}, 9);
        HawConsoles.jsout(res3);
    }

    /**
     * 执行用时：1ms,在所有java提交中击败了99.94%的用户
     * 内存消耗：36.6MB,在所有java提交中击败了94.42%的用户
     */
    private static class Solution3 {

        /**
         * 手动实现hash变体，不使用JAVA API
         */
        public int[] twoSum(int[] nums, int target) {
            // 假设nums最多2048个数字
            int box = 2048;
            int box_1 = box - 1;
            int[] map = new int[box];
            Arrays.fill(map, -1);
            int len = nums.length;
            for (int idx = 0; idx < len; idx++) {
                int num = nums[idx];
                int jdx = map[(target - num) & box_1];
                if (jdx == -1) {
                    map[num & box_1] = idx;
                    continue;
                }
                return new int[]{jdx, idx};
            }
            return null;
        }
    }

    /**
     * 执行用时：2ms,在所有java提交中击败了99.41%的用户
     * 内存消耗：36.8MB,在所有java提交中击败了93.85%的用户
     */
    private static class Solution2 {

        /**
         * 利用hash对内循环进行优化
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int idx = 0; idx < nums.length; idx++) {
                int num = nums[idx];
                int tmp = target - num;
                Integer jdx = map.get(tmp);
                if (jdx == null) {
                    map.put(num, idx);
                    continue;
                }
                return new int[]{idx, jdx};
            }
            return null;
        }
    }

    /**
     * 执行用时：33ms,在所有java提交中击败了40.16%的用户
     * 内存消耗：38MB,在所有java提交中击败了77.89%的用户
     */
    private static class Solution1 {

        /**
         * 双重循环，暴力法
         */
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }

}
