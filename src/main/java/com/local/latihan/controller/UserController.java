package com.local.latihan.controller;

import com.local.latihan.dto.RegisterUserRequest;
import com.local.latihan.dto.UpdateUserRequest;
import com.local.latihan.dto.UserResponse;
import com.local.latihan.dto.WebResponse;
import com.local.latihan.entity.User;
import com.local.latihan.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> register(@RequestBody RegisterUserRequest request) {
        userService.register(request);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(path = "/api/users/current",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<UserResponse> get(User user) {
        UserResponse userResponse = userService.get(user);
        return WebResponse.<UserResponse>builder()
                .data(userResponse).build();

    }

    @PatchMapping(path = "/api/users/current",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<UserResponse> updateUser(User user, @RequestBody UpdateUserRequest request) {
        UserResponse userResponse = userService.updateUser(user, request);
        return WebResponse.<UserResponse>builder()
                .data(userResponse).build();
    }

}
