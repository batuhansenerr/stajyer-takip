package com.batuhansener.stajyerTakip.service;

import com.batuhansener.stajyerTakip.model.Intern;
import com.batuhansener.stajyerTakip.model.User;
import com.batuhansener.stajyerTakip.repository.InternRepository;
import org.springframework.stereotype.Service;

@Service
public class InternService {

    private final InternRepository internRepository;

    public InternService(InternRepository internRepository) {
        this.internRepository = internRepository;
    }

    public Intern createIntern(User user){
        Intern intern = Intern.builder().user(user).build();
        return internRepository.save(intern);
    }
}