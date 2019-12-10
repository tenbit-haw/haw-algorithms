package cn.tenbit.algorithms.util;

import cn.tenbit.haw.core.extend.util.HawTimes;
import cn.tenbit.haw.core.support.HawExecutor;
import cn.tenbit.haw.core.util.HawConsoles;
import cn.tenbit.haw.core.util.HawInvokes;

/**
 * @author bangquan.qian
 * @date 2019-12-10 16:56
 */
public class HawUtils {

    public static void invokeWithStatistics(HawExecutor f) {
        long start = HawTimes.currentTimeMillis();
        try {
            HawInvokes.invoke(f);
        } finally {
            long end = HawTimes.currentTimeMillis();
            HawConsoles.sout("cost: " + (end - start));
        }
    }
}
