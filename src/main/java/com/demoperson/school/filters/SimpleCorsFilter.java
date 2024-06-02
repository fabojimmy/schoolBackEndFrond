package com.demoperson.school.filters;

import java.io.IOException;
import java.util.*;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter{

    // @Value("${app.client.url}")

    // private static final List<String>ALLOWED_ORIGINS=Arrays.asList("http://localhost:8080/");

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
      HttpServletResponse response=(HttpServletResponse) res;
        HttpServletRequest request=(HttpServletRequest) req;

        
        Map<String ,String>map=new HashMap<String ,String>();
        String originHeader=request.getHeader("origin");
        System.out.println(originHeader);
        // if(ALLOWED_ORIGINS.contains(originHeader)){

            response.setHeader("Access-Control-Allow-Origin", originHeader);
            response.setHeader("Access-Control-Allow-Methods", "POST, GET,PUT,PATCH,DELETE,OPTIONS");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "*");
            
            if("OPTIONS".equalsIgnoreCase(request.getMethod()))
            {
                response.setStatus(HttpServletResponse.SC_OK);
            }
            else
            {
                chain.doFilter(req, res);
            }
        // }
        // else{

        //     response.sendError(HttpServletResponse.SC_FORBIDDEN, "Orign not allowed");
        // }
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'doFilter'");
    }
    
}
