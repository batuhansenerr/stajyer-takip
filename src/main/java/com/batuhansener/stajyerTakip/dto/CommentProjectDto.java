package com.batuhansener.stajyerTakip.dto;

import com.batuhansener.stajyerTakip.model.ProjectStatus;
import com.batuhansener.stajyerTakip.model.User;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record CommentProjectDto(
        String id,
        String name,
        String requirements,
        LocalDateTime initialDate,
        LocalDateTime finishDate,
        int score,
        ProjectStatus projectStatus
) {
}
