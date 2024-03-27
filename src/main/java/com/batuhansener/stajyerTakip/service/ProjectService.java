package com.batuhansener.stajyerTakip.service;

import com.batuhansener.stajyerTakip.dto.request.CreateProjectRequest;
import com.batuhansener.stajyerTakip.model.Mentor;
import com.batuhansener.stajyerTakip.model.Project;
import com.batuhansener.stajyerTakip.model.ProjectStatus;
import com.batuhansener.stajyerTakip.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final MentorService mentorService;

    public ProjectService(ProjectRepository projectRepository, MentorService mentorService) {
        this.projectRepository = projectRepository;
        this.mentorService = mentorService;
    }

    public Project create(CreateProjectRequest request){
        Mentor mentor = mentorService.findMentorById(request.mentor_id());
        Project project = Project.builder().name(request.name()).mentor(mentor).initialDate(LocalDateTime.now()).projectStatus(ProjectStatus.ONGOING).build();
        return projectRepository.save(project);
    }
}
