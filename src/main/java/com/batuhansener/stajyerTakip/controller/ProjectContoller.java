package com.batuhansener.stajyerTakip.controller;

import com.batuhansener.stajyerTakip.dto.request.UpdateProjectRequest;
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
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectContoller {

    private final ProjectService projectService;
//    private final MentorService mentorService;
    private final UserService userService;


    @PostMapping("/add")
    public ResponseEntity<ProjectDto> createProject(@RequestBody CreateProjectRequest request){
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

    @PostMapping("/update/{id}")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody UpdateProjectRequest request, @PathVariable String id){
        return ResponseEntity.ok(projectService.update(request, id));
    }
}