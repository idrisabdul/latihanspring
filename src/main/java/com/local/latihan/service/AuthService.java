package com.local.latihan.service;

import com.local.latihan.dto.LoginUserRequest;
import com.local.latihan.dto.TokenResponse;
import com.local.latihan.entity.User;
import com.local.latihan.repository.UserRepository;
import com.local.latihan.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public TokenResponse login(LoginUserRequest request) {
        validationService.validate(request);

        User user = userRepository.findById(request.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "username atau password salah"));

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            // berhasil
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30days());
            userRepository.save(user);

            return TokenResponse.builder()
                    .token(user.getToken())
                    .tokenExpiredAt(user.getTokenExpiredAt())
                    .build();

        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "username atau password salah");
        }

    }

    private Long next30days() {
        return System.currentTimeMillis() + (1000 + 16 + 24 + 30);
    }

}
