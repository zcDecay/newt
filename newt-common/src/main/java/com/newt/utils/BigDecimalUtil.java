package com.newt.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Description: BigDecimal
 * @Author: zcc
 * @Date: 18/09/13
 */
public class BigDecimalUtil {

    public static BigDecimal doubleToBigDecimal(double d) {
        BigDecimal bigDecimal = BigDecimal.valueOf(d);
        return bigDecimal;
    }

    public static BigDecimal getBigDecimal(Object value) {
        BigDecimal ret = null;
        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = BigDecimal.valueOf(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }
        return ret;
    }
}
