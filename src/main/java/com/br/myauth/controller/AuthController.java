package com.br.myauth.controller;

import com.br.myauth.dto.LoginRequest;
import com.br.myauth.dto.LoginResponse;
import com.br.myauth.dto.SignupRequest;
import com.br.myauth.service.UserService;
import com.br.myauth.utils.JwtHelper;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


@RestController
@RequestMapping( "/api/auth/")
public class AuthController {
    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    public AuthController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Valid @RequestBody SignupRequest requestDto) {

        userService.signup(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));

        String token = JwtHelper.generateToken(request.email());

        return ResponseEntity.ok(new LoginResponse(request.email(), token));
    }

}
