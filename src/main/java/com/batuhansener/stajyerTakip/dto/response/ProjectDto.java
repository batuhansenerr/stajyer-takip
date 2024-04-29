package com.batuhansener.stajyerTakip.dto.response;

import com.batuhansener.stajyerTakip.dto.ProjectCommentDto;
import com.batuhansener.stajyerTakip.dto.ProjectUserDto;
import com.batuhansener.stajyerTakip.model.ProjectStatus;
import com.batuhansener.stajyerTakip.model.User;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Builder
public record ProjectDto(
        String id,
        String name,
        String requirements,
        LocalDateTime initialDate,
        LocalDateTime finishDate,
        int score,
        ProjectStatus projectStatus,
        List<ProjectCommentDto> comments,
        List<ProjectUserDto> users

) {
}
