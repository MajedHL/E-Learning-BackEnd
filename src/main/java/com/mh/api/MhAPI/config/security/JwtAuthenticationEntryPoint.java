package com.mh.api.MhAPI.config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

   if(authException.getClass().getCanonicalName().equals(InsufficientAuthenticationException.class.getCanonicalName())) {
       response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
       return;
   }
   response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Bad Request");
    }
}
