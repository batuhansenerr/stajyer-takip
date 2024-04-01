package com.batuhansener.stajyerTakip.dto.response;

import com.batuhansener.stajyerTakip.dto.UserProjectDto;
import lombok.Builder;

import java.util.List;
import java.util.Set;

@Builder
public record UserDto(
        String id,
        String name,
        String surname,
        Set<CommentDto> comments,
        List<UserProjectDto> projects
) {
}
