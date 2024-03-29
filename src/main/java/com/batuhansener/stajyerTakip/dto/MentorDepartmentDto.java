package com.batuhansener.stajyerTakip.dto;

import lombok.Builder;

@Builder
public record MentorDepartmentDto(
        String id,
        String name
) {
}
