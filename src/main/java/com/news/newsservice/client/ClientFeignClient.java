package com.news.newsservice.client;

import com.news.newsservice.dto.JwtDTO;
import com.news.newsservice.responses.TokenVerifyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-services", url = "http://localhost:8080")
public interface ClientFeignClient {

    @PostMapping("/api/auth/verifyToken")
    TokenVerifyResponse verifyToken(@RequestBody JwtDTO jwtDTO);

    @GetMapping("/api/users/userExistsByAccountId/{id}")
    boolean userExistsByAccountId(@PathVariable(name = "id") Long id);
}
