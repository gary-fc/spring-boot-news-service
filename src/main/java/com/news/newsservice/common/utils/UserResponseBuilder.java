package com.news.newsservice.common.utils;

import com.news.newsservice.responses.User;
import com.news.newsservice.responses.UserResponse;

class UserResponseBuilder {
    private UserResponse userResponse;

    private UserResponseBuilder() {
        this.userResponse = new UserResponse();
    }

    static UserResponseBuilder getInstance(User user) {
        return new UserResponseBuilder().setUser(user);
    }

    private UserResponseBuilder setUser(User user) {
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setFullName(user.getFullName());
        userResponse.setAccountId(user.getAccountId());
        return this;
    }

    UserResponse buildUserResponse() {
        return userResponse;
    }
}
