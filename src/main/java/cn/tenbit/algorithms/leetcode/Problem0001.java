package cn.tenbit.algorithms.leetcode;

import cn.tenbit.haw.core.util.HawConsoles;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bangquan.qian
 * @date 2019-11-13 19:43
 */
public class Problem0001 {

    public static void main(String[] args) {
        int[] res1 = new Solution1().twoSum(new int[]{2, 7, 11, 15}, 9);
        HawConsoles.jsout(res1);

        int[] res = new Solution2().twoSum(new int[]{2, 7, 11, 15}, 9);
        HawConsoles.jsout(res);
    }

    /**
     * 执行用时：2ms,在所有java提交中击败了99.41%的用户
     * 内存消耗：36.8MB,在所有java提交中击败了93.85%的用户
     */
    private static class Solution2 {

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
