package com.newt.utils;

/**
 * @Description: 执行是否成功Util
 * @Author: zcc
 * @Date: 18/09/12
 */
public class CommitUtil {
    public static boolean isCommit(int i) {
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }
}
