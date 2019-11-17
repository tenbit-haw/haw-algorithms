package cn.tenbit.algorithms.leetcode;

import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 两数相加
 *
 * @author bangquan.qian
 * @date 2019-11-13 21:04
 */
public class Problem0002 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode lr = new Solution1().addTwoNumbers(l1, l2);
        while (lr != null) {
            HawConsoles.jsout(lr.val);
            lr = lr.next;
        }
    }

    /**
     * 执行用时：2ms,在所有java提交中击败了99.98%的用户
     * 内存消耗：44.9MB,在所有java提交中击败了83.59%的用户
     */
    private static class Solution1 {

        /**
         * 常规链表操作
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode lc = new ListNode(0);
            ListNode lp = lc;
            ListNode lh = lc;
            while (l1 != null || l2 != null) {
                int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + lc.val;
                int ovr = val / 10;
                int cur = val % 10;

                lp = lc;
                lc.val = cur;
                lc.next = new ListNode(ovr);
                lc = lc.next;

                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (lp.next.val == 0) {
                lp.next = null;
            }
            return lh;
        }
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
