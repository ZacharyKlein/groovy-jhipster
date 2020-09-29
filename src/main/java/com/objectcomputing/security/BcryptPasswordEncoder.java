package com.objectcomputing.security;

import org.mindrot.jbcrypt.BCrypt;

import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;

@Singleton
public class BcryptPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(@NotBlank String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt(16));
    }

    @Override
    public boolean matches(@NotBlank String rawPassword, @NotBlank String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }
}
