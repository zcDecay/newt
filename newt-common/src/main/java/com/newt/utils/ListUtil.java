package com.newt.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * List工具类
 *
 * @author wangjx
 */
public class ListUtil {

    /**
     * 判断空
     */
    public static <T> boolean isEmpty(List<T> list) {
        if (list == null || list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static <T> boolean isNotEmpty(List<T> list) {
        if (list != null && !list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 取list的并集（去重）
     */
    public static List<String> unionList(List<String> a, List<String> b) {
        if (CollectionUtils.isEmpty(a) && CollectionUtils.isEmpty(b)) {
            return null;
        }
        List<String> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(a)) {
            result.addAll(b);
        } else if (CollectionUtils.isEmpty(b)) {
            result.addAll(a);
        } else {
            result.addAll(a);
            b.removeAll(result);
            result.addAll(b);
        }
        return result;
    }
}
