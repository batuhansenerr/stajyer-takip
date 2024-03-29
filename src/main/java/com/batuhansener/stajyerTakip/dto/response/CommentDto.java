package com.batuhansener.stajyerTakip.dto.response;

import com.batuhansener.stajyerTakip.dto.ProjectUserDto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentDto(
        String id,
        String comment,
        LocalDateTime releaseDate,
        ProjectUserDto user,
        ProjectDto project
) {
}
