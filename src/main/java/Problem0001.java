import cn.tenbit.haw.core.util.HawConsoles;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bangquan.qian
 * @date 2019-11-13 19:43
 */
public class Problem0001 {

    public static void main(String[] args) {
        int[] res = new Solution2().twoSum(new int[]{2, 7, 11, 15}, 9);
        HawConsoles.jsout(res);
    }

}

class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int idx = 0; idx < nums.length; idx++) {
            int num = nums[idx];
            int tmp = target - num;
            Integer jdx = map.get(tmp);
            if (jdx == null) {
                map.put(num, idx);
                continue;
            }
            return new int[]{idx, jdx};
        }
        return null;
    }
}

class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
