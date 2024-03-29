package com.batuhansener.stajyerTakip.dto;

import lombok.Builder;

@Builder
public record MentorInternDto(
        String id,
        ProjectUserDto user
) {
}
