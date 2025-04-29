package com.br.myauth.dto;

public record LoginResponse (
        String email,
        String token
) {}
