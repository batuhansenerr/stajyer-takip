package com.batuhansener.stajyerTakip.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_INTERN("INTERN"),
    ROLE_MENTOR("MENTOR"),
    ROLE_ADMIN("ADMIN");

    private String value;

    Role(String value){
        this.value = value;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
