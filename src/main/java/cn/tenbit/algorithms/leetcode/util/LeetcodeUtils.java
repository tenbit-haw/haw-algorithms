package cn.tenbit.algorithms.leetcode.util;

import cn.tenbit.algorithms.leetcode.support.ListNode;
import cn.tenbit.haw.core.util.HawAsserts;
import cn.tenbit.haw.core.util.HawJsons;

import java.util.List;

/**
 * @author bangquan.qian
 * @date 2020-01-10 18:29
 */
public class LeetcodeUtils {

    /**
     * [1,2,3]->链表
     */
    public static ListNode genListNode(String str) {
        HawAsserts.notBlank(str);
        List<Integer> list = HawJsons.parseArray(str, Integer.class);
        ListNode head = null;
        ListNode prev = null;
        for (Integer num : list) {
            ListNode tmp = new ListNode(num);
            if (head == null) {
                head = tmp;
                prev = head;
                continue;
            }
            prev.setNext(tmp);
            prev = tmp;
        }
        return head;
    }

    /**
     * [[1,2,3],[1,2,3]]->链表数组
     */
    public static ListNode[] genListNodes(String str) {
        HawAsserts.notBlank(str);
        str = "[" +
                str.replaceAll("^\\[", "")
                        .replaceAll("\\]$", "")
                        .replaceAll("\\[", "\\\"\\[")
                        .replaceAll("\\]", "\\]\\\"")
                + "]";
        List<String> lists = HawJsons.parseArray(str, String.class);
        int size = lists.size();
        ListNode[] result = new ListNode[size];
        for (int idx = 0; idx < size; idx++) {
            result[idx] = genListNode(lists.get(idx));
        }
        return result;
    }
}
