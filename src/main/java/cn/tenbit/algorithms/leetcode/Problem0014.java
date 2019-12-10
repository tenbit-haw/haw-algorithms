package cn.tenbit.algorithms.leetcode;

import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 最长公共前缀
 * <p>
 * 字符串
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0014 {

    public static void main(String[] args) {

        //String[] strs = {"flower", "flow", "flight"};
        //String[] strs = {"dog", "racecar", "car"};
        String[] strs = {"dogd", "dogdo", "dog"};

        String longestCommonPrefix = new Solution1().longestCommonPrefix(strs);
        HawConsoles.jsout(longestCommonPrefix);

    }

    /**
     * 执行用时：1ms,在所有java提交中击败了89.87%的用户
     * 内存消耗：37.5MB,在所有java提交中击败了75.64%的用户
     */
    private static class Solution1 {

        private static final String EMPTY = "";

        /**
         *
         */
        public String longestCommonPrefix(String[] strs) {
            int length = strs.length;
            if (length < 1) {
                return EMPTY;
            }
            char[][] chs = new char[length][];
            int minidx = 0;
            int minlen = strs[0].length();
            for (int idx = 0; idx < length; idx++) {
                String str = strs[idx];
                int len = str.length();
                if (len < 1) {
                    return EMPTY;
                }
                if (minlen > len) {
                    minlen = len;
                    minidx = idx;
                }
                chs[idx] = str.toCharArray();
            }
            char[] res = new char[minlen];
            char[] tgt = chs[minidx];
            int rdx = 0;
            for (; rdx < minlen; rdx++) {
                char tmp = tgt[rdx];
                boolean flg = true;
                for (int jdx = 0; jdx < length; jdx++) {
                    if (jdx == minidx) {
                        continue;
                    }
                    char cmp = chs[jdx][rdx];
                    if (cmp != tmp) {
                        flg = false;
                        break;
                    }
                }
                if (!flg) {
                    break;
                }
                res[rdx] = tmp;
            }
            return String.valueOf(res, 0, rdx);
        }
    }
}
