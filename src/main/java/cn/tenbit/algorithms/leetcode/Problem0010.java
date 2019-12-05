package cn.tenbit.algorithms.leetcode;

import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 正则表达式匹配
 * <p>
 * 字符串
 * 动态规划
 * 回溯算法
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0010 {

    public static void main(String[] args) {
        String text = "123";
        String pattern = ".*";

        boolean match1 = new Solution1().isMatch(text, pattern);
        HawConsoles.jsout(match1);

        boolean match2 = new Solution2().isMatch(text, pattern);
        HawConsoles.jsout(match2);
    }

    /**
     * 执行用时：2ms,在所有java提交中击败了99.88%的用户
     * 内存消耗：35.8MB,在所有java提交中击败了89.54%的用户
     */
    private static class Solution1 {

        /**
         * 动态规划（自顶而下）
         */
        public boolean isMatch(String text, String pattern) {
            int tlen = text.length();
            int plen = pattern.length();
            char[] tchs = text.toCharArray();
            char[] pchs = pattern.toCharArray();
            Boolean[][] table = new Boolean[tlen + 1][plen + 1];
            return dp(table, tlen, plen, tchs, pchs, 0, 0);
        }

        private boolean dp(Boolean[][] table, int tlen, int plen, char[] tchs, char[] pchs, int tidx, int pidx) {
            if (table[tidx][pidx] != null) {
                return table[tidx][pidx];
            }
            boolean ans = false;
            if (pidx == plen) {
                ans = tidx == tlen;
            } else {
                boolean first = tidx < tlen && (pchs[pidx] == tchs[tidx] || pchs[pidx] == '.');
                if (pidx + 1 < plen && pchs[pidx + 1] == '*') {
                    ans = dp(table, tlen, plen, tchs, pchs, tidx, pidx + 2) || first && dp(table, tlen, plen, tchs, pchs, tidx + 1, pidx);
                } else {
                    ans = first && dp(table, tlen, plen, tchs, pchs, tidx + 1, pidx + 1);
                }
            }
            table[tidx][pidx] = ans;
            return ans;
        }

    }

    /**
     * 执行用时：2ms,在所有java提交中击败了99.88%的用户
     * 内存消耗：36.2MB,在所有java提交中击败了87.82%的用户
     */
    private static class Solution2 {

        /**
         * 动态规划（自底而上）
         */
        public boolean isMatch(String text, String pattern) {
            int tlen = text.length();
            int plen = pattern.length();
            char[] tchs = text.toCharArray();
            char[] pchs = pattern.toCharArray();
            boolean[][] table = new boolean[tlen + 1][plen + 1];
            table[tlen][plen] = true;
            for (int tdx = tlen; tdx > -1; tdx--) {
                for (int pdx = plen - 1; pdx > -1; pdx--) {
                    boolean first = tdx < tlen && (pchs[pdx] == tchs[tdx] || pchs[pdx] == '.');
                    boolean ans = false;
                    if (pdx + 1 < plen && pchs[pdx + 1] == '*') {
                        ans = table[tdx][pdx + 2] || first && table[tdx + 1][pdx];
                    } else {
                        ans = first && table[tdx + 1][pdx + 1];
                    }
                    table[tdx][pdx] = ans;
                }
            }
            return table[0][0];
        }

    }
}
