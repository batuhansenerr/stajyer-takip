package com.batuhansener.stajyerTakip.dto.response;

import com.batuhansener.stajyerTakip.dto.MentorDepartmentDto;
import com.batuhansener.stajyerTakip.dto.MentorInternDto;
import com.batuhansener.stajyerTakip.dto.ProjectUserDto;
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
