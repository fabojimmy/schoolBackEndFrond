package com.demoperson.school.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.demoperson.school.serviceimpl.UserDetailsLoad;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{
    
     @Autowired
    private UserDetailsLoad userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;

    String token=null;
    String username=null;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader=request.getHeader("Authorization");
       

        // if(request.getServletPath().matches("/auth/login|/user/forgotPassword|/user/signup|users/getalluser"))
        // {
        //         filterChain.doFilter(request, response);
        // }
        // else{

            if(authHeader!=null && authHeader.startsWith("Bearer ")) {
                token=authHeader.substring(7);
    
                username=jwtUtils.extractUsername(token);
                System.out.println(username+"okkkkkkk,,nhhhg");
            }
            // System.out.println(username+"cddd0"+SecurityContextHolder.getContext().getAuthentication());
            if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
                System.out.printf("Authentication");
                UserDetails userDetails=userDetailsService.loadUserByUsername(username);
                System.out.println(userDetails.getUsername());
    
                if(jwtUtils.validateToken(token, userDetails)){
                    UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
    
            filterChain.doFilter(request, response);
        }


      
    // }

}
