package com.batuhansener.stajyerTakip.controller;

import com.batuhansener.stajyerTakip.dto.response.ProjectDto;
import com.batuhansener.stajyerTakip.dto.response.UserDto;
import com.batuhansener.stajyerTakip.dto.request.AssignUserToProjectRequest;
import com.batuhansener.stajyerTakip.dto.request.CreateProjectRequest;
import com.batuhansener.stajyerTakip.model.Project;
import com.batuhansener.stajyerTakip.model.User;
import com.batuhansener.stajyerTakip.service.ProjectService;
import com.batuhansener.stajyerTakip.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectContoller {

    private final ProjectService projectService;
//    private final MentorService mentorService;
    private final UserService userService;


    @PostMapping("/add")
    public ResponseEntity<ProjectDto> createProject(@RequestBody CreateProjectRequest request){
        System.out.println("noluyo");
        return ResponseEntity.ok(projectService.create(request));
    }

    @PostMapping("/assignUser")
    public ResponseEntity<UserDto> assignUser(@RequestBody AssignUserToProjectRequest request){
        User user = userService.findUserById(request.user_id());
        Project project = projectService.findProjectById(request.project_id());
        project.getUsers().add(user);
        user.getProjects().add(project);
        projectService.genericUpdateProject(project);
        return ResponseEntity.ok(userService.assignInternToProject(user, project));
    }

    @GetMapping
    public String getAllMentorProjects(){
//        mentorService.findAuthenticatedMentor();
        return "selam";
    }
}