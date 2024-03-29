package com.batuhansener.stajyerTakip.dto;

import com.batuhansener.stajyerTakip.model.Mentor;
import lombok.Builder;

@Builder
public record InternDto(
        String id,
        InternMentorDto mentor
) {
}
