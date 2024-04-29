package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.response.ProjectDto;
import com.batuhansener.stajyerTakip.model.Comment;
import com.batuhansener.stajyerTakip.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectDtoConverter {

    private final ProjectCommentDtoConverter projectCommentDtoConverter;
    private final ProjectUserConverter projectUserConverter;

    public ProjectDto convert(Project project){
        List<Comment> sortedComments = project.getSortedComments();

        return ProjectDto.builder().id(project.getId()).name(project.getName()).score(project.getScore())
                .requirements(project.getRequirements())
                .initialDate(project.getInitialDate()).finishDate(project.getFinishDate())
                .projectStatus(project.getProjectStatus())
                .users(project.getUsers().stream().map(projectUserConverter::convert).collect(Collectors.toList()))
                .comments(sortedComments.stream().map(projectCommentDtoConverter::convert).collect(Collectors.toList())).build();
    }
}
