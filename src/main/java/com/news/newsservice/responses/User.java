package com.news.newsservice.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long accountId;
    private String fullName;
    private String username;
    private String email;
}


