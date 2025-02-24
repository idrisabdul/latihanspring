package com.local.latihan.service;

import com.local.latihan.dto.RegisterUserRequest;
import com.local.latihan.entity.User;
import com.local.latihan.repository.UserRepository;
import com.local.latihan.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;


    @Transactional
    public void register(RegisterUserRequest request) {
        validationService.validate(request);

        if (userRepository.existsById(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username sudah ada yang gunakan");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());
        userRepository.save(user);
    }
}
