package com.feljtech.istudybucket.service;

import com.feljtech.istudybucket.dto.request.LoginRequest;
import com.feljtech.istudybucket.dto.request.RegisterRequest;
import com.feljtech.istudybucket.security.jwt.JwtRefreshTokenRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> registerAccount(RegisterRequest registerRequest);

    boolean verifyAccount(String verificationToken, String username);

    ResponseEntity<?> loginUser(LoginRequest loginRequest) throws Exception;

    ResponseEntity<?> validateRefreshToken(JwtRefreshTokenRequest jwtRefreshTokenRequest);

    ResponseEntity<?> refreshToken(JwtRefreshTokenRequest jwtRefreshTokenRequest);

    ResponseEntity<String> logoutUser(JwtRefreshTokenRequest jwtRefreshTokenRequest);
}