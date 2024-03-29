package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.InternMentorDto;
import com.batuhansener.stajyerTakip.model.Mentor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InternMentorConverter {

    private final ProjectUserConverter projectUserConverter;

    public InternMentorDto convert(Mentor mentor){
        return InternMentorDto.builder().id(mentor.getId()).user(projectUserConverter.convert(mentor.getUser())).build();
    }
}
