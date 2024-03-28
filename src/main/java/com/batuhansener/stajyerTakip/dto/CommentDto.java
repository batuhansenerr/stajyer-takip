package com.batuhansener.stajyerTakip.dto;

import com.batuhansener.stajyerTakip.model.Project;
import com.batuhansener.stajyerTakip.model.User;
import lombok.Builder;
import org.springframework.stereotype.Component;

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
