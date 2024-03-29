package com.batuhansener.stajyerTakip.controller;

import com.batuhansener.stajyerTakip.dto.InternDto;
import com.batuhansener.stajyerTakip.dto.request.AssignInternToMentorRequest;
import com.batuhansener.stajyerTakip.dto.request.AssignMentorToDepartment;
import com.batuhansener.stajyerTakip.model.Intern;
import com.batuhansener.stajyerTakip.model.Mentor;
import com.batuhansener.stajyerTakip.service.InternService;
import com.batuhansener.stajyerTakip.service.MentorService;
import com.batuhansener.stajyerTakip.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final InternService internService;
    private final MentorService mentorService;

    @PostMapping("/assignInternToMentor")
    public ResponseEntity<InternDto> assignInternToMentor(@RequestBody AssignInternToMentorRequest request){
        Intern intern = internService.findInternById(request.intern_id());
        Mentor mentor = mentorService.findMentorById(request.mentor_id());
        return ResponseEntity.ok(internService.assignIntern(intern, mentor));
    }


}
