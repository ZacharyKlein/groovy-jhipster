package com.objectcomputing.security;

import javax.validation.constraints.NotBlank;

public interface PasswordEncoder {
    String encode(@NotBlank String rawPassword);

    boolean matches(@NotBlank String rawPassword, @NotBlank String encodedPassword);
}