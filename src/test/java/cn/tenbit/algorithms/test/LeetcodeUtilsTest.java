package cn.tenbit.algorithms.test;

import cn.tenbit.algorithms.leetcode.support.ListNode;
import cn.tenbit.algorithms.leetcode.util.LeetcodeUtils;
import cn.tenbit.haw.core.util.HawConsoles;
import org.junit.Test;

/**
 * @author bangquan.qian
 * @date 2020-01-10 18:58
 */
public class LeetcodeUtilsTest {

    @Test
    public void test1() {
        String str = "[1,2,3]";
        ListNode node = LeetcodeUtils.genListNode(str);
        HawConsoles.jsout(node);
    }

    @Test
    public void test2() {
        String str = "[[1,2,3],[8,9,0]]";
        ListNode[] nodes = LeetcodeUtils.genListNodes(str);
        HawConsoles.jsout(nodes);
    }
}
