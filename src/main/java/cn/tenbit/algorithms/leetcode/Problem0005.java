package cn.tenbit.algorithms.leetcode;

import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 最长回文子串
 * <p>
 * 字符串
 * 动态规划
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0005 {

    public static void main(String[] args) {
        String str = new Solution2().longestPalindrome("abbcbbbeeeebbb");
        HawConsoles.jsout(str);
    }

    /**
     * Manacher
     */
    private static class Solution {

        public String longestPalindrome(String s) {
            if (s == null) {
                return "";
            }
            s = process(s);
            int r = -1;
            int c = -1;
            int max = Integer.MIN_VALUE;
            int iMax = 0;
            StringBuilder stringBuilder;
            int[] rArray = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                rArray[i] = r <= i ? 1 : Math.min(rArray[2 * c - i], r - i);
                while (i + rArray[i] < s.length() && i - rArray[i] > -1) {
                    if (s.charAt(i + rArray[i]) == s.charAt(i - rArray[i])) {
                        rArray[i]++;
                    } else {
                        break;
                    }
                }
                if (i + rArray[i] > r) {
                    r = i + rArray[i];
                    c = i;
                }
                if (rArray[i] > max) {
                    max = rArray[i];
                    iMax = i;
                }
            }
            stringBuilder = new StringBuilder();
            for (int j = iMax - max + 1; j < iMax + max; j++) {
                if ('#' != s.charAt(j)) {
                    stringBuilder.append(s.charAt(j));
                }
            }
            return stringBuilder.toString();
        }

        private static String process(String s) {
            StringBuilder stringBuilder = new StringBuilder("#");
            for (char c : s.toCharArray()) {
                stringBuilder.append(c).append("#");
            }
            return stringBuilder.toString();
        }

    }

    private static class Solution4 {

        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                int length1 = expandAroundCenter(s, i, i);
                int length2 = expandAroundCenter(s, i, i + 1);
                int length = Math.max(length1, length2);
                if (length > end - start) {
                    start = i - (length - 1) / 2;
                    end = i + length / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }

    private static class Solution3 {

        public String longestPalindrome(String s) {
            if (s == null || s.equals("")) return s;
            char[] schar = s.toCharArray();
            int range[] = new int[2];
            for (int i = 0; i < s.length(); i++) {
                i = findLongest(schar, i, range);
            }
            return s.substring(range[0], range[1] + 1);
        }

        public int findLongest(char[] str, int low, int[] range) {
            int high = low;
            // 查找中间部分（定位重复的最后一个字符high，将从low到high的字符看作一个中间字符）
            while (high < str.length - 1 && str[high + 1] == str[low]) {
                high++;
            }
            int ans = high;
            while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
                low--;
                high++;
            }
            if (high - low > range[1] - range[0]) {
                range[0] = low;
                range[1] = high;
            }
            return ans;
        }
    }

    /**
     * 执行用时：52ms,在所有java提交中击败了50.93%的用户
     * 内存消耗：37.4MB,在所有java提交中击败了81.36%的用户
     */
    private static class Solution2 {

        /**
         * 动态规划
         * <p>
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(n^2)
         */
        public String longestPalindrome(String s) {
            char[] chs = s.toCharArray();
            int len = chs.length;
            int max = 0;
            int srt = 0;
            int end = 0;
            boolean[][] tab = new boolean[len][len];
            for (int ten = 1; ten <= len; ten++) {
                for (int fo = 0; fo < len; fo++) {
                    int to = fo + ten - 1;
                    if (to + 1 > len) {
                        break;
                    }
                    // 动态规划思想，缓存判断结果，先判断小范围的结果，然后大范围结果使用历史结果判断即可，减少运算
                    boolean ok = tab[fo][to] = (ten < 3 || tab[fo + 1][to - 1]) && chs[fo] == chs[to];
                    if (!ok) {
                        continue;
                    }
                    if (ten <= max) {
                        continue;
                    }
                    max = ten;
                    srt = fo;
                    end = to;
                }
            }
            return String.copyValueOf(chs, srt, max);
        }

    }

    /**
     * 思路正确，但结果超时
     */
    private static class Solution1 {

        /**
         * 暴力法，三重循环
         * <p>
         * O(n^3)
         */
        public String longestPalindrome(String s) {
            char[] chs = s.toCharArray();
            int len = chs.length;
            int max = 0;
            int srt = 0;
            int end = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    boolean ok = true;
                    for (int k = i; k <= j; k++) {
                        char a = chs[k];
                        char b = chs[i + j - k];
                        if (a != b) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) {
                        continue;
                    }
                    int tmx = j - i + 1;
                    if (tmx <= max) {
                        continue;
                    }
                    max = tmx;
                    srt = i;
                    end = j;
                }
            }
            return s.substring(srt, end + 1);
        }

    }
}
