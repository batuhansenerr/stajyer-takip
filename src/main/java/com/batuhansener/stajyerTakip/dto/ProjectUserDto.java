package com.batuhansener.stajyerTakip.dto;

import lombok.Builder;

@Builder
public record ProjectUserDto(
        String id,
        String name,
        String surname
) {
}
