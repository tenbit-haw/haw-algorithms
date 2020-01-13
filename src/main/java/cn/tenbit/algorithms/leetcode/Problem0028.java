package cn.tenbit.algorithms.leetcode;

import cn.tenbit.algorithms.util.HawUtils;
import cn.tenbit.haw.core.support.HawExecutor;
import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 实现 strStr()
 * <p>
 * 双指针
 * 字符串
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0028 {

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
        String str = "a";
        String fid = "a";
        int idx = new Solution1().strStr(str, fid);
        HawConsoles.jsout(idx);
    }

    /**
     * 执行用时：248ms,在所有Java提交中击败了7.22%的用户
     * 内存消耗：35.9MB,在所有Java提交中击败了84.27%的用户
     */
    private static class Solution1 {

        /**
         * 暴力算法，优化建议：KMP
         */
        public int strStr(String str, String fid) {
            char[] chs = str.toCharArray();
            char[] fds = fid.toCharArray();
            int len1 = chs.length;
            int len2 = fds.length;
            if (len1 < 1 || len2 < 1) {
                return 0;
            }
            for (int i = 0; i < len1; i++) {
                boolean ok = true;
                for (int j = 0, t = i; j < len2; j++, t++) {
                    if (t > len1 - 1 || chs[t] != fds[j]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return i;
                }
            }
            return -1;
        }
    }
}
