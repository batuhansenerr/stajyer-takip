package com.batuhansener.stajyerTakip.service;

import com.batuhansener.stajyerTakip.dto.InternDto;
import com.batuhansener.stajyerTakip.dto.converter.InternDtoConverter;
import com.batuhansener.stajyerTakip.exception.MentorNotFoundException;
import com.batuhansener.stajyerTakip.model.Intern;
import com.batuhansener.stajyerTakip.model.Mentor;
import com.batuhansener.stajyerTakip.model.User;
import com.batuhansener.stajyerTakip.repository.InternRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InternService {

    private final InternRepository internRepository;
    private final InternDtoConverter internDtoConverter;


    public Intern createIntern(User user){
        Intern intern = Intern.builder().user(user).build();
        return internRepository.save(intern);
    }

    public Intern findInternById(String id){
        return internRepository.findById(id).orElseThrow(()->new MentorNotFoundException("intern yok"));
    }

    public InternDto assignIntern(Intern intern, Mentor mentor) {
        intern.setMentor(mentor);
        intern = internRepository.saveAndFlush(intern);
        return internDtoConverter.convert(intern);
    }
}