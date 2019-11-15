package cn.tenbit.algorithms.leetcode;

import cn.tenbit.haw.core.util.HawConsoles;

/**
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0003 {

    public static void main(String[] args) {
        int len = new Solution1().lengthOfLongestSubstring("jbpnbwwd");
        HawConsoles.jsout(len);
    }

    private static class Solution2 {

        public int lengthOfLongestSubstring(String s) {
            char[] chs = s.toCharArray();
            int len = chs.length;
            int max = 0;
            for (int srt = 0; srt < len; srt++) {
                boolean[] tab = new boolean[128];
                int tmx = 1;
                tab[chs[srt]] = true;
                for (int end = srt + 1; end < len; end++) {
                    int tmp = chs[end];
                    if (tab[tmp]) {
                        break;
                    }
                    tab[tmp] = true;
                    tmx++;
                }
                if (tmx > max) {
                    max = tmx;
                }
            }
            return max;
        }
    }

    /**
     * 执行用时：6ms,在所有java提交中击败了90.45%的用户
     * 内存消耗：37.3MB,在所有java提交中击败了93.51%的用户
     */
    private static class Solution1 {

        public int lengthOfLongestSubstring(String s) {
            char[] chs = s.toCharArray();
            int len = chs.length;
            int max = 0;
            for (int srt = 0; srt < len; srt++) {
                // 通用做法(支持Unicode)使用Set
                boolean[] tab = new boolean[128];
                int tmx = 0;
                for (int end = srt; end < len; end++) {
                    int tmp = chs[end];
                    if (tab[tmp]) {
                        break;
                    }
                    tab[tmp] = true;
                    tmx++;
                }
                if (tmx > max) {
                    max = tmx;
                }
            }
            return max;
        }
    }
}
