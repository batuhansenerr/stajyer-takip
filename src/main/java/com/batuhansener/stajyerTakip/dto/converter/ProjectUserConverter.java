package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.ProjectUserDto;
import com.batuhansener.stajyerTakip.model.User;
import org.springframework.stereotype.Component;

@Component
public class ProjectUserConverter {

    public ProjectUserDto convert(User user){
        return ProjectUserDto.builder().id(user.getId()).name(user.getName()).surname(user.getSurname()).build();
    }
}
