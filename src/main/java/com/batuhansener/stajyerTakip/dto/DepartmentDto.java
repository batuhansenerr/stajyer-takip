package com.batuhansener.stajyerTakip.dto;

import com.batuhansener.stajyerTakip.model.Mentor;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Builder
public record DepartmentDto (
        String id,
        String name,
        Set<Mentor> mentors
) {}
