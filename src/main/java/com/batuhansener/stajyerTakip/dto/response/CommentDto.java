package com.batuhansener.stajyerTakip.dto.response;

import com.batuhansener.stajyerTakip.dto.CommentProjectDto;
import com.batuhansener.stajyerTakip.dto.ProjectUserDto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentDto(
        String id,
        String comment,
        LocalDateTime releaseDate,
        ProjectUserDto user,
        CommentProjectDto project
) {
}
