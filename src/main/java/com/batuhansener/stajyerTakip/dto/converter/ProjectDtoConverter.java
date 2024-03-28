package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.CommentProjectDto;
import com.batuhansener.stajyerTakip.dto.ProjectCommentDto;
import com.batuhansener.stajyerTakip.dto.ProjectDto;
import com.batuhansener.stajyerTakip.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectDtoConverter {

    private final ProjectCommentDtoConverter projectCommentDtoConverter;
    private final ProjectUserConverter projectUserConverter;

    public ProjectDto convert(Project project){
        return ProjectDto.builder().id(project.getId()).name(project.getName()).score(project.getScore())
                .initialDate(project.getInitialDate()).finishDate(project.getFinishDate())
                .projectStatus(project.getProjectStatus())
                .users(project.getUsers().stream().map(projectUserConverter::convert).collect(Collectors.toList()))
                .comments(project.getComments().stream().map(projectCommentDtoConverter::convert).collect(Collectors.toList())).build();
    }
}
