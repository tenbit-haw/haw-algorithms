package cn.tenbit.algorithms.leetcode;

import cn.tenbit.algorithms.util.HawUtils;
import cn.tenbit.haw.core.support.HawExecutor;
import cn.tenbit.haw.core.util.HawConsoles;

/**
 * 有效的括号
 * <p>
 * 栈
 * 字符串
 *
 * @author bangquan.qian
 * @date 2019-11-14 19:16
 */
public class Problem0020 {

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
        String s = "[({})]";
        boolean valid = new Solution1().isValid(s);
        HawConsoles.jsout(valid);
    }

    /**
     * 执行用时：1ms,在所有java提交中击败了99.10%的用户
     * 内存消耗：34.2MB,在所有java提交中击败了86.16%的用户
     */
    private static class Solution1 {

        /**
         * 栈
         */
        public boolean isValid(String s) {
            char[] chs = s.toCharArray();
            int len = chs.length;
            Stack stack = new Stack(len);
            for (int idx = 0; idx < len; idx++) {
                char val = chs[idx];
                if (stack.length() < 1 || !chk(stack.peek(), val)) {
                    stack.push(val);
                    continue;
                }
                stack.pop();
            }
            return stack.length() < 1;
        }

        private boolean chk(char pop, char tgt) {
            if (pop == '(') {
                return tgt == ')';
            } else if (pop == '[') {
                return tgt == ']';
            } else if (pop == '{') {
                return tgt == '}';
            }
            return false;
        }


        private static class Stack {

            private char[] value;

            private int top;

            private final int max;

            public Stack(int len) {
                this.max = len;
                this.value = new char[len];
            }

            public void push(char val) {
                assert top <= max;
                value[top++] = val;
            }

            public char peek() {
                assert top > 0;
                return value[top - 1];
            }

            public char pop() {
                char val = peek();
                value[--top] = 0;
                return val;
            }

            public int length() {
                return top;
            }
        }
    }
}
