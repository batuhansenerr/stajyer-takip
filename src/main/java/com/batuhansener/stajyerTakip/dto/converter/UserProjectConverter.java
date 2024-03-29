package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.UserProjectDto;
import com.batuhansener.stajyerTakip.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class UserProjectConverter {

    private final ProjectCommentDtoConverter projectCommentDtoConverter;

    public UserProjectDto convert(Project project){
        return UserProjectDto.builder().id(project.getId()).name(project.getName()).score(project.getScore())
                .initialDate(project.getInitialDate()).finishDate(project.getFinishDate())
                .projectStatus(project.getProjectStatus())
                .comments(project.getComments().stream().map(projectCommentDtoConverter::convert).collect(Collectors.toList())).build();
    }
}
