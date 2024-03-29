package com.batuhansener.stajyerTakip.service;

import com.batuhansener.stajyerTakip.dto.converter.MentorDtoConverter;
import com.batuhansener.stajyerTakip.dto.response.MentorDto;
import com.batuhansener.stajyerTakip.exception.MentorNotFoundException;
import com.batuhansener.stajyerTakip.model.Department;
import com.batuhansener.stajyerTakip.model.Mentor;
import com.batuhansener.stajyerTakip.model.User;
import com.batuhansener.stajyerTakip.repository.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MentorService {
    private final MentorRepository mentorRepository;
    private final MentorDtoConverter mentorDtoConverter;


    public Mentor createMentor(User user){
        Mentor mentor = Mentor.builder()
                .user(user).build();
        return mentorRepository.save(mentor);
    }

    public Mentor findMentorById(String id){
        return mentorRepository.findById(id).orElseThrow(()->new MentorNotFoundException("mentor yok"));
    }

    public MentorDto assignMentor(Department department, Mentor mentor) {
        mentor.setDepartment(department);
        mentor = mentorRepository.saveAndFlush(mentor);
        return mentorDtoConverter.convert(mentor);
    }

//    public Mentor findMentorByUserId(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        return mentorRepository.findByUserId(id);
//    }

//    public Mentor findAuthenticatedMentor(){
//        Mentor mentor = findMentorById(jwtService.extractId().toString());
//        System.out.println(mentor.getProjects());
//        return mentor;
//    }
}
