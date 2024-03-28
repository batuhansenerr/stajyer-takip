package com.batuhansener.stajyerTakip.dto;

import com.batuhansener.stajyerTakip.model.User;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ProjectCommentDto(
        String id,
        String comment,
        LocalDateTime releaseDate,
        ProjectUserDto user
) {
}
