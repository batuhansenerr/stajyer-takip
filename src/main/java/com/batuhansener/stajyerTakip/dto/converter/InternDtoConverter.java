package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.response.InternDto;
import com.batuhansener.stajyerTakip.model.Intern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InternDtoConverter {

    private final InternMentorConverter internMentorConverter;
    private final ProjectUserConverter projectUserConverter;

    public InternDto convert(Intern intern){
        return InternDto.builder().id(intern.getId()).user(projectUserConverter.convert(intern.getUser())).mentor(internMentorConverter.convert(intern.getMentor())).build();
    }
}
