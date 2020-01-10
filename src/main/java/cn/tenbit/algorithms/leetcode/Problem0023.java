package cn.tenbit.algorithms.leetcode;

import cn.tenbit.algorithms.leetcode.support.ListNode;
import cn.tenbit.algorithms.leetcode.util.LeetcodeUtils;
import cn.tenbit.algorithms.util.HawUtils;
import cn.tenbit.haw.core.support.HawExecutor;
import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 合并K个排序链表
 * <p>
 * 堆
 * 链表
 * 分治算法
 *
 * @author bangquan.qian
 * @date 2020-01-08 17:16
 */
public class Problem0023 {

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
        String str = null;
        //str = "[[1,4,5],[1,3,4],[2,6]]";
        str = "[[1]]";
        ListNode node = new Solution1().mergeKLists(LeetcodeUtils.genListNodes(str));
        HawConsoles.jsout(node);
    }

    /**
     * 执行用时：4ms,在所有Java提交中击败了74.58%的用户
     * 内存消耗：41.6MB,在所有Java提交中击败了78.30%的用户
     */
    private static class Solution1 {

        /**
         * 分治&合并
         */
        public ListNode mergeKLists(final ListNode[] lists) {
            int len = lists.length;
            if (len < 1) {
                return null;
            }
            ListNode[] old = lists;
            ListNode[] tmp = new ListNode[len];
            tmp[0] = old[0];
            int cur = 0;
            while (len > 1) {
                for (int idx = 0; idx < len; idx++) {
                    ListNode lst1 = old[idx];
                    if (idx + 1 == len) {
                        tmp[cur] = lst1;
                    } else {
                        ListNode lst2 = old[++idx];
                        tmp[cur] = merge(lst1, lst2);
                    }
                    cur++;
                }
                old = tmp;
                len = cur;
                cur = 0;
            }
            return tmp[0];
        }

        /**
         * 双指针
         */
        private ListNode merge(ListNode lst1, ListNode lst2) {
            ListNode nlst = new ListNode(-1);
            ListNode tmp = nlst;
            while (lst1 != null || lst2 != null) {
                boolean bval1 = false;
                int val1 = -1;
                if (lst1 != null) {
                    val1 = lst1.val;
                    bval1 = true;
                }

                boolean bval2 = false;
                int val2 = -1;
                if (lst2 != null) {
                    val2 = lst2.val;
                    bval2 = true;
                }

                ListNode next = null;
                if (bval1 && bval2) {
                    if (val1 < val2) {
                        next = lst1;
                        lst1 = lst1.next;
                    } else {
                        next = lst2;
                        lst2 = lst2.next;
                    }
                } else if (bval1) {
                    next = lst1;
                    lst1 = lst1.next;
                } else if (bval2) {
                    next = lst2;
                    lst2 = lst2.next;
                }

                tmp.next = new ListNode(next.val);
                tmp = tmp.next;
            }
            return nlst.next;
        }
    }
}
