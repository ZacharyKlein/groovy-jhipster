package com.objectcomputing.security;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;

@Introspected
public class Logout {

    @NonNull
    @NotBlank
    private String logoutUrl;

    public Logout() {
    }

    @NonNull
    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(@NonNull String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }
}
