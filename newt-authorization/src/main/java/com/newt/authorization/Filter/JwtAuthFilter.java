package com.newt.authorization.Filter;

import com.newt.Constants.Constants;
import com.newt.authorization.utils.JwtUtil;
import com.newt.pojo.vo.UserVo;
import com.newt.utils.CookieUtil;
import com.newt.utils.EmptyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.subject.WebSubject;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description jwt过滤器
 * @Author zcc
 * @Date 18/10/26
 */
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        if (EmptyUtil.isEmpty(principal)) {
            String token = request.getHeader(Constants.TOKEN_KEY);
            if (StringUtils.isBlank(token)) {
                token = CookieUtil.getCookie(request, Constants.TOKEN_KEY);
            }

            if (StringUtils.isNotBlank(token)) {
                UserVo user = JwtUtil.parseToken(token);

                //解码
                if (EmptyUtil.isNotEmpty(user)) {
                    PrincipalCollection principals = new SimplePrincipalCollection(user, "customRealm");
                    WebSubject.Builder builder = new WebSubject.Builder(request, response);
                    builder.principals(principals);
                    builder.authenticated(true);
                    WebSubject subject = builder.buildWebSubject();
                    /*塞入容器，统一调用*/
                    ThreadContext.bind(subject);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
