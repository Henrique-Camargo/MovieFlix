package com.movieflix.user.controller;

import com.movieflix.config.exception.UsernameAndPasswordInvalidException;
import com.movieflix.docs.AuthDocs;
import com.movieflix.user.mapper.UserMapper;
import com.movieflix.user.model.User;
import com.movieflix.user.request.LoginRequest;
import com.movieflix.user.response.LoginResponse;
import com.movieflix.user.response.UserResponse;
import com.movieflix.user.request.UserRequest;
import com.movieflix.config.TokenService;
import com.movieflix.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/auth")
@RequiredArgsConstructor
public class AuthController implements AuthDocs {

    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){
        User savedUser= service.save(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authentication = authenticationManager.authenticate(userAndPass);
            User user = (User) authentication.getPrincipal();
            return ResponseEntity.ok(new LoginResponse(tokenService.generateToken(user)));
        }catch (BadCredentialsException e){
            throw new UsernameAndPasswordInvalidException("Usuario ou senha invalido.");
        }
    }



}
