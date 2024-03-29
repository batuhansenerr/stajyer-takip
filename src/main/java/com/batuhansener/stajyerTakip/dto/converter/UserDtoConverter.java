package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.response.UserDto;
import com.batuhansener.stajyerTakip.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserDtoConverter {

    private final UserProjectConverter userProjectConverter;

    public UserDto convert(User user){
        return UserDto.builder().id(user.getId()).name(user.getName()).surname(user.getSurname())
                .projects(user.getProjects().stream().map(userProjectConverter::convert).collect(Collectors.toList()))
                .build();
    }
}
