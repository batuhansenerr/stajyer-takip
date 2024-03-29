package com.batuhansener.stajyerTakip.dto;

import lombok.Builder;

@Builder
public record InternMentorDto(
        String id,
        ProjectUserDto user
) {
}
