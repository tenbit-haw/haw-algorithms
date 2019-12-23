package cn.tenbit.algorithms.leetcode;

import cn.tenbit.algorithms.util.HawUtils;
import cn.tenbit.haw.core.support.HawExecutor;
import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 删除链表的倒数第N个节点
 * <p>
 * 链表
 * 双指针
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0019 {

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

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode node = new Solution1().removeNthFromEnd(n1, 2);
        HawConsoles.jsout(node);
    }

    private static class ListNode {
        int val;

        ListNode next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 执行用时：0ms,在所有java提交中击败了100.00%的用户
     * 内存消耗：35MB,在所有java提交中击败了86.63%的用户
     */
    private static class Solution1 {

        /**
         * 虚拟头结点，双指针
         */
        public ListNode removeNthFromEnd(ListNode h, int tgt) {
            ListNode w = new ListNode(-1);
            w.next = h;
            ListNode c = w;
            ListNode t = c;
            ListNode b = c;
            int dst = 1;
            while (c.next != null) {
                c = c.next;
                if (dst < tgt) {
                    dst++;
                } else if (dst == tgt) {
                    b = t;
                    t = t.next;
                }
            }
            b.next = t.next;
            return w.next;
        }
    }
}
