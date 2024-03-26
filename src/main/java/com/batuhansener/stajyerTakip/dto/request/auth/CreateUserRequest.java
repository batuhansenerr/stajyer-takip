package com.batuhansener.stajyerTakip.dto.request.auth;

import com.batuhansener.stajyerTakip.model.Role;
import lombok.Builder;

import java.util.Set;


@Builder
public record CreateUserRequest (
        String name,
        String username,
        String password,
        Set<Role> authorities
){ }