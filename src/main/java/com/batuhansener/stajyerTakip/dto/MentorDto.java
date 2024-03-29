package com.batuhansener.stajyerTakip.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record MentorDto(
        String id,
        MentorDepartmentDto department,
        ProjectUserDto user,
        Set<MentorInternDto> interns
) {
}
