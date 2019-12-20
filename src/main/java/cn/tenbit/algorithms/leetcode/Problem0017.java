package cn.tenbit.algorithms.leetcode;

import cn.tenbit.algorithms.util.HawUtils;
import cn.tenbit.haw.core.support.HawExecutor;
import cn.tenbit.haw.core.util.HawConsoles;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * <p>
 * 字符串
 * 回溯算法
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0017 {

    public static void main(String[] args) {
        HawUtils.invokeWithStatistics(new HawExecutor() {
            @Override
            public Object execute() throws Throwable {
                test();
                return null;
            }
        });
    }

    private static void test() {
        String digits = "23";
        List<String> list = new Solution1().letterCombinations(digits);
        HawConsoles.jsout(list);
    }

    /**
     * 执行用时：0ms,在所有java提交中击败了100.00%的用户
     * 内存消耗：36MB,在所有java提交中击败了73.55%的用户
     */
    private static class Solution1 {

        private static final char[][] tab = new char[10][];

        static {
            tab[2] = new char[]{'a', 'b', 'c'};
            tab[3] = new char[]{'d', 'e', 'f'};
            tab[4] = new char[]{'g', 'h', 'i'};
            tab[5] = new char[]{'j', 'k', 'l'};
            tab[6] = new char[]{'m', 'n', 'o'};
            tab[7] = new char[]{'p', 'q', 'r', 's'};
            tab[8] = new char[]{'t', 'u', 'v'};
            tab[9] = new char[]{'w', 'x', 'y', 'z'};
        }

        /**
         * 递归&回溯
         */
        public List<String> letterCombinations(String digits) {
            List<String> lst = new ArrayList<>();
            int len = digits.length();
            if (len < 1) {
                return lst;
            }
            char[] chs = digits.toCharArray();
            char[] buf = new char[len];
            recursion(lst, chs, len, 0, buf);
            return lst;
        }

        private void recursion(List<String> lst, char[] chs, int len, int idx, char[] buf) {
            if (idx == len) {
                lst.add(new String(buf));
                return;
            }

            char ch = chs[idx];
            char[] tchs = tab[ch - '0'];
            int tlen = tchs.length;
            for (int jdx = 0; jdx < tlen; jdx++) {
                buf[idx] = tchs[jdx];
                recursion(lst, chs, len, idx + 1, buf);
            }
        }
    }
}
