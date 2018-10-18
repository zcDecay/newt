package com.newt.utils;

import com.newt.pojo.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description WebUtil
 * @Author zcc
 * @Date 18/09/26
 */
public class WebUtil {

    private static final int DEFAULT_PAGE_SIZE = 20;

    private static final int MAX_PAGE_SIZE = 100;

    public static final String TOKEN_KEY = "Newt-Token";

    /**
     * 获取当前用户信息
     *
     * @return
     */
    public static UserVo getUser() {
        UserVo info = new UserVo();
        String token = getToken(TOKEN_KEY);
        if (StringUtils.isNotBlank(token)) {
            info = JwtUtil.parseToken(token);
        }
        return info;
    }

    /**
     * 获取token
     *
     * @return
     */
    public static String getToken(String tokenName) {
        HttpServletRequest request = getRequest();
        String token = CookieUtil.getCookie(request, tokenName);
        if (StringUtils.isBlank(token)) {
            token = request.getHeader(tokenName);
        }
        if (StringUtils.isBlank(token)) {
            String strategy = CookieUtil.getCookie(request, "auth.newt");
            if (StringUtils.isNotBlank(strategy)) {
                token = CookieUtil.getCookie(request, "auth._token." + strategy);
                if (StringUtils.isNotBlank(token)) {
                    token = token.replaceFirst("Bearer%20", "");
                }
            }

        }
        return token;
    }

    /**
     * 获取请求全路径
     *
     * @param request
     * @return
     */
    public static String getFullURL(HttpServletRequest request) {
        StringBuffer url = request.getRequestURL();
        if (request.getQueryString() != null) {
            url.append("?");
            url.append(request.getQueryString());
        }
        return url.toString();
    }

    /**
     * 获取请求路径，去除项目名
     *
     * @param request
     * @return
     */
    public static String getURL(HttpServletRequest request) {
        String coyoteRequest = request.getRequestURI();
        return coyoteRequest;
    }

    public static String getIP() {
        return WebUtil.getIP(getRequest());
    }

    /**
     * 获得IP地址：如：127.0.0.1
     *
     * @param request
     * @return
     */
    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-Server");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-Host");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 判断是否为ajax请求
     *
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        if (request.getParameterMap().containsKey("inajax")) {
            if (request.getParameter("inajax").equals("1")) {
                return true;
            }
        }
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    /**
     * 获取HTTP Request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return WebContextHolder.getInstance().getRequest();
    }

    /**
     * 获取HTTP Session
     *
     * @return
     */
    public static HttpSession getSession() {
        return WebContextHolder.getInstance().getSession();
    }

    /**
     * 获取当前页
     *
     * @return
     */
    public static int getPageNum() {
        int p = 1;
        String pageNum = getRequest().getParameter("pageNum");
        if (StringUtils.isNotBlank(pageNum) && NumberUtils.isCreatable(pageNum)) {
            p = Integer.parseInt(pageNum);
        }
        return p;
    }

    /**
     * 获取每页显示记录数
     *
     * @return
     */
    public static int getPageSize() {
        int s = DEFAULT_PAGE_SIZE;
        String pageSize = getRequest().getParameter("pageSize");
        if (StringUtils.isNotBlank(pageSize) && NumberUtils.isCreatable(pageSize)) {
            s = Integer.parseInt(pageSize);
            if (s > MAX_PAGE_SIZE) {
                s = MAX_PAGE_SIZE;
            }
        }
        return s;
    }
    /**
     * @Description: 获取排序
     * @param:  * @param
     * @return: java.lang.String
     */
    public static String getOrder(){
        HttpServletRequest request = getRequest();
        String column = request.getParameter("sortName");
        String sort = request.getParameter("sortOrder");
        if (StringUtils.isBlank(column)){
            return "CREATE_TIME";
        }
        column = CamelCaseUtil.toUnderlineName(column);
        if (StringUtils.isBlank(sort))  {
            sort = "DESC";
        }
        return column + " " + sort;

    }
}
