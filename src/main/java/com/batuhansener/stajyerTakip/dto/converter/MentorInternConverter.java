package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.MentorInternDto;
import com.batuhansener.stajyerTakip.model.Intern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MentorInternConverter {
    private final ProjectUserConverter projectUserConverter;

    public MentorInternDto convert(Intern intern){
        return MentorInternDto.builder().id(intern.getId()).user(projectUserConverter.convert(intern.getUser())).build();
    }
}
