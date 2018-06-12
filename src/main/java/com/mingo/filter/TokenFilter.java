package com.mingo.filter;

import com.mingo.constant.Global;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:mingo
 * Date:2018/5/24 21:53
 * Description:授权token
 * 根据环境变量不同来不同配置
 * 测试token展示在页头便于测试，线上的token邮件告知调用方
 */
public class TokenFilter implements Filter {

    private String token;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        token = Global.SPRING_PROPERTIES.get("http.token");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String reqToken = ((HttpServletRequest)servletRequest).getHeader("authorization");
        if (!token.equals(reqToken)) {
            ((HttpServletResponse)servletResponse).setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
