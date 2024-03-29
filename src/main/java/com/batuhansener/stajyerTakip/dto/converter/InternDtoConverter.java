package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.InternDto;
import com.batuhansener.stajyerTakip.model.Intern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InternDtoConverter {

    private final InternMentorConverter internMentorConverter;

    public InternDto convert(Intern intern){
        return InternDto.builder().id(intern.getId()).mentor(internMentorConverter.convert(intern.getMentor())).build();
    }
}
