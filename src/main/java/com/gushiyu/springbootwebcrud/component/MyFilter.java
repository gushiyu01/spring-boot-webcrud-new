package com.gushiyu.springbootwebcrud.component;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init******");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy******");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String remoteAddr = servletRequest.getRemoteAddr();
        String name = servletRequest.getParameter("name");
        Object name1 = servletRequest.getAttribute("name");
        System.out.println(remoteAddr + "name:" + name + name1);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
