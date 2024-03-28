package com.batuhansener.stajyerTakip.service;

import com.batuhansener.stajyerTakip.exception.MentorNotFoundException;
import com.batuhansener.stajyerTakip.model.Mentor;
import com.batuhansener.stajyerTakip.model.User;
import com.batuhansener.stajyerTakip.repository.MentorRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class MentorService {
    private final MentorRepository mentorRepository;


    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Mentor createMentor(User user){
        Mentor mentor = Mentor.builder()
                .user(user).build();
        return mentorRepository.save(mentor);
    }

    public Mentor findMentorById(String id){
        return mentorRepository.findById(id).orElseThrow(()->new MentorNotFoundException("mentor yok"));
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
