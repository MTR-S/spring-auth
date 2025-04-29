package com.br.myauth.service;

import com.br.myauth.dto.SignupRequest;
import com.br.myauth.entity.UserEntity;
import com.br.myauth.repository.UserRepository;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void signup(SignupRequest request) {
        String email = request.email();

        if (userRepository.findByEmail(email).isPresent()) {
            throw new DuplicateKeyException(String.format("User with the email address '%s' already exists.", email));
        }

        UserEntity user = new UserEntity(
                request.name(),
                email,
                passwordEncoder.encode(request.password())
        );

        userRepository.save(user);
    }
}
