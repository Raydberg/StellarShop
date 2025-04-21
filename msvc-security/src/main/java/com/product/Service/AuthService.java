package com.product.Service;

import com.product.Models.UserCredential;
import com.product.Repository.IUsuarioCredential;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final IUsuarioCredential repository;
    private final JwtService jwtService;

    public String saveUser(UserCredential credential) {
        try {
            credential.setPassword(passwordEncoder.encode(credential.getPassword()));
            repository.save(credential);
            return "Usuario registrado";
        } catch (
                Exception e) {
            log.error("Usuario no registrado:".concat(e.getMessage()));
            return "Usuario no registrado";
        }
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
