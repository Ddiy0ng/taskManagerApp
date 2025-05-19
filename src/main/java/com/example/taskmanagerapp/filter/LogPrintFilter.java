package com.example.taskmanagerapp.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogPrintFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //ServletRequest는 기능이 별로 없어 HttpServlet로 다운 캐스팅 해서 사용
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //실제 요청으로 들어온 URI를 변수에 할당
        String requestURI = httpServletRequest.getRequestURI();

        log.info("request URI = {}", requestURI);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
