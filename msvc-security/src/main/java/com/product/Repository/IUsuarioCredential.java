package com.product.Repository;

import com.product.Models.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioCredential extends JpaRepository<UserCredential, Long> {
    Optional<UserCredential> findByEmail(String email);

//    Optional<UserCredential> findUserCredentialsByEmail(String email);

//    Optional<UserCredential> findByName(String name);
}
