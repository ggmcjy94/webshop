package com.example.webshop.infra.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Slf4j
@WebFilter(urlPatterns = "*")
public class FilterConfig implements Filter {

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //전 처리 과정
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        // 전, 후 처리의 기준이 되는 메소드
        chain.doFilter(request, response);
        //후 처리 과정

        String requestURI = httpServletRequest.getRequestURI();
        if (!requestURI.contains("/node_modules")) {
            log.info("[{}][{}][{}]", httpServletResponse.getStatus(), httpServletRequest.getRequestURL(), LocalDateTime.now());
            String log = "[" + httpServletResponse.getStatus() + "]"
                    + "[" +httpServletRequest.getRequestURL() +"]"
                    + "[" + LocalDateTime.now() + "]" + "\n";
            BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream("input.log", true));
            bf.write(log.getBytes(StandardCharsets.UTF_8));
            bf.close();
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
