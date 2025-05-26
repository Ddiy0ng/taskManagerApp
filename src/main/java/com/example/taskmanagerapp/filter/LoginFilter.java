package com.example.taskmanagerapp.filter;

import com.example.taskmanagerapp.exceptionHandler.customError.LoginAuthenticationException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

@Slf4j
public class LoginFilter implements Filter {
    private static final String[] FILTER_PASS_URI = {"/login", "/authors/signUp"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //ServletRequest는 기능이 별로 없어 HttpServlet로 다운 캐스팅 해서 사용
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //실제 요청으로 들어온 URI를 변수에 할당
        String requestURI = httpServletRequest.getRequestURI();
        /*
         *log: 프로그램이 실행되면서 남기는 기록
         * - 디버깅, 운영 기록(사용자 접속, 처리 결과 등), 통계, 테스트 등의 용도로 활용
         */
        log.info("로그인 필터 로직 실행");

        //패턴에 불일치 하면 필터 로직(인증 로직) 실행
        if(!isFilterPassUri(requestURI)){
            //세션이 없으면 null 반환
            HttpSession httpSession = httpServletRequest.getSession(false);
            if(httpSession == null || httpSession.getAttribute("sessionKey") == null) {
                log.warn("세션이 없거나 세션 키가 유효하지 않습니다.");
                throw new LoginAuthenticationException();
            }
        }
        log.info("필터 통과!.");
        //다음 필터가 없으면 서블릿과 컨트롤러가 요청되게 만들어주고 다음 필터가 있으면 다음 필터를 호출한다.
        filterChain.doFilter(servletRequest, servletResponse);
    }


    private boolean isFilterPassUri(String requestURI){
        //Pattern에 일치하면 true 반환
        return PatternMatchUtils.simpleMatch(FILTER_PASS_URI, requestURI);
    }
}