package com.br.myauth.service;

import com.br.myauth.entity.LoginAttemptEntity;
import com.br.myauth.repository.LoginAttemptRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class LoginService {

    private final LoginAttemptRepository repository;

    public LoginService(LoginAttemptRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void addLoginAttempt(String email, boolean status) {
        LoginAttemptEntity loginAttempt = new LoginAttemptEntity(email, status, LocalDateTime.now());

        repository.save(loginAttempt);
    }

    public Optional<List<LoginAttemptEntity>> findRecentLoginAttempts(String email) {

        return repository.findByEmail(email);
    }
}
