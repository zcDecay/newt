package com.newt.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: Cookie
 * @Author: zcc
 * @Date: 18/09/12
 */
public class CookieUtil {

    public static String getCookie(HttpServletRequest httpServletRequest, String cookieKey) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null) {
            return null;
        }

        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals(cookieKey)) {
                return cookie.getValue();
            }
        }

        return null;
    }


    public static void addCookie(HttpServletResponse httpServletResponse, int cookieExpiration, String cookieKey,
                                 String cookieValue) {
        Cookie cookie = new Cookie(cookieKey, cookieValue);
        cookie.setMaxAge(cookieExpiration);
        httpServletResponse.addCookie(cookie);
    }
}
