package com.batuhansener.stajyerTakip.dto.response;

import com.batuhansener.stajyerTakip.dto.InternMentorDto;
import com.batuhansener.stajyerTakip.dto.ProjectUserDto;
import com.batuhansener.stajyerTakip.model.Mentor;
import lombok.Builder;

@Builder
public record InternDto(
        String id,
        ProjectUserDto user,
        InternMentorDto mentor
) {
}
