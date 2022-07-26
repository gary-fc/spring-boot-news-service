package com.news.newsservice.services.Auth.AuthServiceImpl;

import com.news.newsservice.dto.JwtDTO;
import com.news.newsservice.exception.NotFoundException;
import com.news.newsservice.feign.UserFeignClient;
import com.news.newsservice.responses.TokenVerifyResponse;
import com.news.newsservice.responses.User;
import com.news.newsservice.services.Auth.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserFeignClient userFeignClient;

    public AuthServiceImpl(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    @Override
    public TokenVerifyResponse verifyToken(JwtDTO jwtDTO) {
        return userFeignClient.verifyToken(jwtDTO);
    }

    @Override
    public User userByAccountId(Long id) {
        try {
            return userFeignClient.userByAccountId(id);
        } catch (Exception e) {
            throw new NotFoundException("Account");
        }
    }


}
