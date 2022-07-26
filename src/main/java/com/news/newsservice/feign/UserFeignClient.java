package com.news.newsservice.feign;

import com.news.newsservice.dto.JwtDTO;
import com.news.newsservice.responses.TokenVerifyResponse;
import com.news.newsservice.responses.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service")
public interface UserFeignClient {

    @PostMapping("/api-user/auth/verifyToken")
    TokenVerifyResponse verifyToken(@RequestBody JwtDTO jwtDTO);

    @GetMapping("/api-user/users/byAccountId/{id}")
    User userByAccountId(@PathVariable(name = "id") Long id);
}
