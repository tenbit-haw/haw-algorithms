package cn.tenbit.algorithms.leetcode;

import cn.tenbit.algorithms.util.HawUtils;
import cn.tenbit.haw.core.support.HawExecutor;
import cn.tenbit.haw.core.util.HawConsoles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * <p>
 * 数组
 * 双指针
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0015 {

    public static void main(String[] args) {
        HawUtils.invokeWithStatistics(new HawExecutor() {
            @Override
            public Object execute() throws Throwable {
                test();
                return null;
            }
        });

        HawUtils.invokeWithStatistics(new HawExecutor() {
            @Override
            public Object execute() throws Throwable {
                test2();
                return null;
            }
        });
    }

    private static void test2() {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {14, 4, 6, -1, 10, 9, -8, 7, -13, 14, -13, -11, -8, -9, 11, 14, -8, -14, -13, 7, -10, -15, -13, -11, -11, 11, 14, 13, 2, -14, 1, -7, -2, 14, -1, -15, 9, 7, -1, 3, 6, 1, 7, 5, -1, -5, 4, -2, -4, -1, -9, -7, -1, -7, -11, 3, 12, 10, -7, -1, 12, 1, 8, -13, 1, 14, 9, -13, 6, -7, -3, -11, 2, -11, 10, -14, -1, -9, 0, 2, 5, 6, 3, -11, 6, 7, 0, 3, 3, 0, -12, -8, -13, 3, -14, -5, 2, 10, -11, -14, -12, 1, -10, 5, 5, 7, -1, 11, 14, 6, -10, -4, -3, 8, -7, 10, 1, 8, -1, -11, -15, -6, -12, -13, 12, -11};

        List<List<Integer>> lst = new Solution2().threeSum(nums);
        HawConsoles.jsout(lst);
    }

    /**
     * 执行用时：49ms,在所有java提交中击败了49.63%的用户
     * 内存消耗：46.6MB,在所有java提交中击败了95.74%的用户
     */
    private static class Solution2 {

        /**
         * 双指针优化
         * <p>
         * O(n^2)
         */
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            List<List<Integer>> lst = new ArrayList<>();
            for (int idx = 0; idx < len - 2; idx++) {
                int now = nums[idx];
                if (idx > 0 && now == nums[idx - 1]) {
                    // 去重
                    continue;
                }
                int ldx = idx + 1;
                int rdx = len - 1;
                while (ldx < rdx) {
                    int lft = nums[ldx];
                    if (ldx > idx + 1 && lft == nums[ldx - 1]) {
                        // 去重
                        ldx++;
                        continue;
                    }
                    int rgt = nums[rdx];
                    if (rdx < len - 1 && rgt == nums[rdx + 1]) {
                        // 去重
                        rdx--;
                        continue;
                    }
                    int res = now + lft + rgt;
                    if (res > 0) {
                        rdx--;
                        continue;
                    } else if (res < 0) {
                        ldx++;
                        continue;
                    }
                    List<Integer> one = new ArrayList<>();
                    one.add(now);
                    one.add(lft);
                    one.add(rgt);
                    lst.add(one);
                    ldx++;
                    rdx--;
                }
            }
            return lst;
        }
    }

    private static void test() {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {14, 4, 6, -1, 10, 9, -8, 7, -13, 14, -13, -11, -8, -9, 11, 14, -8, -14, -13, 7, -10, -15, -13, -11, -11, 11, 14, 13, 2, -14, 1, -7, -2, 14, -1, -15, 9, 7, -1, 3, 6, 1, 7, 5, -1, -5, 4, -2, -4, -1, -9, -7, -1, -7, -11, 3, 12, 10, -7, -1, 12, 1, 8, -13, 1, 14, 9, -13, 6, -7, -3, -11, 2, -11, 10, -14, -1, -9, 0, 2, 5, 6, 3, -11, 6, 7, 0, 3, 3, 0, -12, -8, -13, 3, -14, -5, 2, 10, -11, -14, -12, 1, -10, 5, 5, 7, -1, 11, 14, 6, -10, -4, -3, 8, -7, 10, 1, 8, -1, -11, -15, -6, -12, -13, 12, -11};

        List<List<Integer>> lst = new Solution1().threeSum(nums);
        HawConsoles.jsout(lst);
    }

    /**
     * 超出时间限制
     */
    private static class Solution1 {

        /**
         * 暴力法
         * <p>
         * O(n^3)
         */
        public List<List<Integer>> threeSum(int[] nums) {
            int len = nums.length;
            int buf = len * len * len;
            if (buf < 0) {
                buf = Integer.MAX_VALUE;
            }
            int[][] tab = new int[buf][3];
            int[] tmp = new int[3];
            int cur = 0;
            for (int i = 0; i < len - 2; i++) {
                for (int j = i + 1; j < len - 1; j++) {
                    for (int k = j + 1; k < len; k++) {
                        int n1 = nums[i];
                        int n2 = nums[j];
                        int n3 = nums[k];
                        int res = n1 + n2 + n3;
                        if (res != 0) {
                            continue;
                        }
                        tmp[0] = n1;
                        tmp[1] = n2;
                        tmp[2] = n3;
                        sort(tmp);
                        boolean chk = chk(tab, cur, tmp);
                        if (chk) {
                            tab[cur++] = cpy(tmp);
                        }
                    }
                }
            }
            List<List<Integer>> lst = new ArrayList<>();
            for (int i = 0; i < cur; i++) {
                int[] lne = tab[i];
                List<Integer> one = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    one.add(lne[j]);
                }
                lst.add(one);
            }
            return lst;
        }

        private boolean chk(int[][] tab, int cur, int[] tmp) {
            for (int i = 0; i < cur; i++) {
                int[] lne = tab[i];
                int cnt = 0;
                for (int j = 0; j < 3; j++) {
                    if (lne[j] == tmp[j]) {
                        cnt++;
                    }
                }
                if (cnt == 3) {
                    return false;
                }
            }
            return true;
        }

        private int[] cpy(int[] tmp) {
            int len = tmp.length;
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                res[i] = tmp[i];
            }
            return res;
        }

        public void sort(int[] arr) {
            int len = arr.length;
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int a = arr[i];
                    int b = arr[j];
                    if (a <= b) {
                        continue;
                    }
                    arr[i] = b;
                    arr[j] = a;
                }
            }
        }
    }
}
