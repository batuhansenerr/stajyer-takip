package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.MentorDepartmentDto;
import com.batuhansener.stajyerTakip.model.Department;
import org.springframework.stereotype.Component;

@Component
public class MentorDepartmentConverter {

    public MentorDepartmentDto convert(Department department){
        return MentorDepartmentDto.builder().id(department.getId()).name(department.getName()).build();
    }
}
