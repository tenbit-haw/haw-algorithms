package cn.tenbit.algorithms.leetcode;

import cn.tenbit.algorithms.util.HawUtils;
import cn.tenbit.haw.core.support.HawExecutor;
import cn.tenbit.haw.core.util.HawConsoles;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * <p>
 * 字符串
 * 回溯算法
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0022 {

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
        List<String> list = new Solution1().generateParenthesis(3);
        HawConsoles.jsout(list);
    }

    private static void test2() {

    }

    private static class Solution2 {

        /**
         * 暴力
         */
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            // 递归所有情况，再判断每个情况
            return res;
        }
    }

    /**
     * 执行用时：1ms,在所有java提交中击败了99.40%的用户
     * 内存消耗：36.4MB,在所有java提交中击败了98.27%的用户
     */
    private static class Solution1 {

        /**
         * 递归&回溯
         */
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            int max = n << 1;
            char[] buf = new char[max];
            recursion(res, 0, 0, n, 0, max, buf);
            return res;
        }

        private void recursion(List<String> res, int open, int close, int num, int idx, int max, char[] buf) {
            if (idx == max) {
                res.add(new String(buf));
                return;
            }

            if (open < num) {
                buf[idx] = '(';
                recursion(res, open + 1, close, num, idx + 1, max, buf);
            }
            if (open > close) {
                buf[idx] = ')';
                recursion(res, open, close + 1, num, idx + 1, max, buf);
            }
        }
    }
}
