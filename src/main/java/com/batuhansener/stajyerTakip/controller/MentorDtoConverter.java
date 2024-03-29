package com.batuhansener.stajyerTakip.controller;

import com.batuhansener.stajyerTakip.dto.MentorDto;
import com.batuhansener.stajyerTakip.dto.converter.MentorDepartmentConverter;
import com.batuhansener.stajyerTakip.dto.converter.MentorInternConverter;
import com.batuhansener.stajyerTakip.dto.converter.ProjectUserConverter;
import com.batuhansener.stajyerTakip.model.Mentor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MentorDtoConverter {

    private final MentorDepartmentConverter mentorDepartmentConverter;
    private final MentorInternConverter mentorInternConverter;
    private final ProjectUserConverter projectUserConverter;

    public MentorDto convert(Mentor mentor){
        return MentorDto.builder().id(mentor.getId()).department(mentorDepartmentConverter.convert(mentor.getDepartment()))
                .interns(mentor.getInterns().stream().map(mentorInternConverter::convert).collect(Collectors.toSet()))
                .user(projectUserConverter.convert(mentor.getUser())).build();
    }
}
