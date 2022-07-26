package com.news.newsservice.services.Auth;

import com.news.newsservice.dto.JwtDTO;
import com.news.newsservice.responses.TokenVerifyResponse;
import com.news.newsservice.responses.User;

public interface AuthService {
    TokenVerifyResponse verifyToken(JwtDTO jwtDTO);

    User userByAccountId(Long id);
}
