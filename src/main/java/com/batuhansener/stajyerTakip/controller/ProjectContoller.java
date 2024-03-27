package com.batuhansener.stajyerTakip.controller;

import com.batuhansener.stajyerTakip.dto.request.CreateProjectRequest;
import com.batuhansener.stajyerTakip.model.Project;
import com.batuhansener.stajyerTakip.service.MentorService;
import com.batuhansener.stajyerTakip.service.ProjectService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectContoller {

    private final ProjectService projectService;
    private final MentorService mentorService;

    public ProjectContoller(ProjectService projectService, MentorService mentorService) {
        this.projectService = projectService;
        this.mentorService = mentorService;
    }

    @PostMapping("/addNewProject")
    public ResponseEntity<Project> createProject(@RequestBody CreateProjectRequest request){
        return ResponseEntity.ok(projectService.create(request));
    }

    @GetMapping
    public String getAllMentorProjects(){
//        mentorService.findAuthenticatedMentor();
        return "selam";
    }
}
