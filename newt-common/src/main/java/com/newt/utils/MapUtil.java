package com.newt.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MapUtil {

    public static Map<String, String> objToMap(Object obj) {

        Map<String, String> map = new HashMap<>(100);
        /*获取f对象对应类中的所有属性域*/
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            /*将key置为小写，默认为对象的属性*/
            varName = varName.toLowerCase();
            try {
                /*获取原来的访问控制权限*/
                boolean accessFlag = fields[i].isAccessible();
                /*修改访问控制权限*/
                fields[i].setAccessible(true);
                /*获取在对象f中属性fields[i]对应的对象中的变量*/
                Object o = fields[i].get(obj);
                if (o != null){
                    map.put(varName, o.toString());
                }
                /*恢复访问控制权限*/
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }
}
