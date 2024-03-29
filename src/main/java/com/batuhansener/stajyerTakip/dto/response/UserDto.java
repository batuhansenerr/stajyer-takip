package com.batuhansener.stajyerTakip.dto.response;

import com.batuhansener.stajyerTakip.dto.UserProjectDto;
import lombok.Builder;

import java.util.List;

@Builder
public record UserDto(
        String id,
        String name,
        String surname,
        List<UserProjectDto> projects
) {
}
