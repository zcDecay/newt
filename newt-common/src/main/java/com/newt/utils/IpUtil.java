/**
 * Project Name:cnknys-common File Name:IpUtils.java Package Name:com.cnknys.common.utils Date:2017年7月17日上午11:24:15 Copyright (c) 2017,
 * chenzhou1025@126.com All Rights Reserved.
 */

package com.newt.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: ipUtil
 * @Author: zcc
 * @Date: 18/09/13
 */
public class IpUtil {
    private static final String UN_KNOWN = "unknown";

    public static String getIp(HttpServletRequest request) {
        String clientIp = request.getHeader("x-forwarded-for");
        if (clientIp == null || clientIp.length() == 0 || UN_KNOWN.equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || UN_KNOWN.equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || UN_KNOWN.equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }
        return clientIp;
    }
}
