package com.niit.StoryMicroService.Filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest httprequest= (HttpServletRequest) request;
        HttpServletResponse httpresponse = (HttpServletResponse) response;

        String authheader = httprequest.getHeader("authorization");
        System.out.println("Auth Header"+ authheader);

        if(authheader==null || !authheader.startsWith("Bearer"))
        {
            throw new ServletException("Missing or Invalid Authentication Header");
        }

        String jwtToken = authheader.substring(7);
        System.out.println(jwtToken);
        Claims claims=Jwts.parser().setSigningKey("secret key")
                .parseClaimsJws(jwtToken).getBody();
        httprequest.setAttribute("email", claims);
        chain.doFilter(request, response);
    }

}

