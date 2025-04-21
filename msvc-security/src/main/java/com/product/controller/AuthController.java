package com.product.controller;

import com.product.Dto.AuthRequestDto;
import com.product.Models.UserCredential;
import com.product.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public String Register(@RequestBody UserCredential user) {
        return authService.saveUser(user);
    }

    @PostMapping("/token")
    public String GetToken(@RequestBody AuthRequestDto dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.username(), dto.password())
        );

        if (authentication.isAuthenticated()) {
            return authService.generateToken(dto.username());
        } else {
            throw new AuthenticationCredentialsNotFoundException("Acceso invalido");
        }

    }

    @GetMapping("/validate")
    public String ValidateToken(@RequestParam("token") String token) {
        authService.validateToken(token);
        return "Token Valido";
    }

}
