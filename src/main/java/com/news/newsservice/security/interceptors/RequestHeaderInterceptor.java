package com.news.newsservice.security.interceptors;

import com.news.newsservice.dto.JwtDTO;
import com.news.newsservice.services.Auth.AuthService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestHeaderInterceptor implements HandlerInterceptor {

    private final AuthService authService;

    public RequestHeaderInterceptor(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if (authorization != null) {
            JwtDTO jwtDTO = new JwtDTO();
            jwtDTO.setAccessToken(authorization.split(" ")[1]);
            if (authService.verifyToken(jwtDTO).isValid()) {
                return true;
            }
            response.sendError(401, "Token no valid");
            return false;
        }
        response.sendError(401, "Not found authorization");
        return false;
    }


}
