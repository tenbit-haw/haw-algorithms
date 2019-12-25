package cn.tenbit.algorithms.leetcode;

import cn.tenbit.algorithms.util.HawUtils;
import cn.tenbit.haw.core.support.HawExecutor;
import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 合并两个有序链表
 * <p>
 * 链表
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0021 {

    public static void main(String[] args) {
        HawUtils.invokeWithStatistics(new HawExecutor() {
            @Override
            public Object execute() throws Throwable {
                test();
                return null;
            }
        });
        HawUtils.invokeWithStatistics(new HawExecutor() {
            @Override
            public Object execute() throws Throwable {
                test2();
                return null;
            }
        });
    }

    private static void test2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n3;
        n3.next = n5;

        n2.next = n4;

        ListNode lst = new Solution2().mergeTwoLists(n1, n2);
        HawConsoles.jsout(lst);
    }

    private static void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n3;
        n3.next = n5;

        n2.next = n4;

        ListNode lst = new Solution1().mergeTwoLists(n1, n2);
        HawConsoles.jsout(lst);
    }

    /**
     * 执行用时：1ms,在所有java提交中击败了81.16%的用户
     * 内存消耗：40.2MB,在所有java提交中击败了53.11%的用户
     */
    private static class Solution2 {

        /**
         * 递归，减少不必要的内存消耗
         */
        public ListNode mergeTwoLists(ListNode lst1, ListNode lst2) {
            if (lst1 == null) {
                return lst2;
            } else if (lst2 == null) {
                return lst1;
            } else if (lst1.val < lst2.val) {
                lst1.next = mergeTwoLists(lst1.next, lst2);
                return lst1;
            } else {
                lst2.next = mergeTwoLists(lst1, lst2.next);
                return lst2;
            }
        }
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
     * 执行用时：1ms,在所有java提交中击败了81.16%的用户
     * 内存消耗：41.1MB,在所有java提交中击败了29.45%的用户
     */
    private static class Solution1 {

        /**
         * 链表
         */
        public ListNode mergeTwoLists(ListNode lst1, ListNode lst2) {
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
