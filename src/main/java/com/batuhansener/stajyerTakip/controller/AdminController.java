package com.batuhansener.stajyerTakip.controller;

import com.batuhansener.stajyerTakip.dto.response.InternDto;
import com.batuhansener.stajyerTakip.dto.response.MentorDto;
import com.batuhansener.stajyerTakip.dto.request.AssignInternToMentorRequest;
import com.batuhansener.stajyerTakip.dto.request.AssignMentorToDepartment;
import com.batuhansener.stajyerTakip.dto.response.ProjectDto;
import com.batuhansener.stajyerTakip.dto.response.UserDto;
import com.batuhansener.stajyerTakip.model.Department;
import com.batuhansener.stajyerTakip.model.Intern;
import com.batuhansener.stajyerTakip.model.Mentor;
import com.batuhansener.stajyerTakip.model.User;
import com.batuhansener.stajyerTakip.service.*;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final InternService internService;
    private final DepartmentService departmentService;
    private final MentorService mentorService;
    private final ProjectService projectService;

    @PostMapping("/assignInternToMentor")
    public ResponseEntity<InternDto> assignInternToMentor(@RequestBody AssignInternToMentorRequest request){
        Intern intern = internService.findInternById(request.intern_id());
        Mentor mentor = mentorService.findMentorById(request.mentor_id());
        return ResponseEntity.ok(internService.assignInternToMentor(intern, mentor));
    }

    @PostMapping("/assignMentorToDepartment")
    public ResponseEntity<MentorDto> assignMentorToDepartment(@RequestBody AssignMentorToDepartment request){
        Department department = departmentService.findDepartmentById(request.department_id());
        Mentor mentor = mentorService.findMentorById(request.mentor_id());
        return ResponseEntity.ok(mentorService.assignMentor(department, mentor));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }


}
