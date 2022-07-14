package com.news.newsservice.services.Auth.AuthServiceImpl;

import com.news.newsservice.client.ClientFeignClient;
import com.news.newsservice.dto.JwtDTO;
import com.news.newsservice.responses.TokenVerifyResponse;
import com.news.newsservice.services.Auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private ClientFeignClient clientFeignClient;

    @Override
    public TokenVerifyResponse verifyToken(JwtDTO jwtDTO) {
        return clientFeignClient.verifyToken(jwtDTO);
    }

    @Override
    public boolean userExistsByAccountId(Long id) {
        return clientFeignClient.userExistsByAccountId(id);
    }


}
