package com.news.newsservice.services.Auth;

import com.news.newsservice.dto.JwtDTO;
import com.news.newsservice.responses.TokenVerifyResponse;

public interface AuthService {
    TokenVerifyResponse verifyToken(JwtDTO jwtDTO);

    boolean userExistsByAccountId(Long id);
}
