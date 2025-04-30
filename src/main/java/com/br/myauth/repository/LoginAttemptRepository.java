package com.br.myauth.repository;

import com.br.myauth.entity.LoginAttemptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginAttemptRepository extends JpaRepository<LoginAttemptEntity, Long> {
    Optional<List<LoginAttemptEntity>> findByEmail(String email);
}
