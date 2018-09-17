package com.newt.utils;

import java.util.List;

/**
 * @Description: 判断对象是否为空
 * @Author: zcc
 * @Date: 18/09/12
 */
public class EmptyUtil {
    /**
     * 判断对象为空
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof List)) {
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String)) {
            return ((String) obj).trim().equals("");
        }
        return false;
    }

    /**
     * 判断对象不为空
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 判断空（只要有一个为空结果就为空，返回true）
     */
    public static boolean isAnyEmpty(Object... obj) {
        if (obj == null || obj.length == 0) {
            return true;
        }
        for (Object o : obj) {
            if (isEmpty(o)) {
                return true;
            }
        }
        return false;
    }
}
