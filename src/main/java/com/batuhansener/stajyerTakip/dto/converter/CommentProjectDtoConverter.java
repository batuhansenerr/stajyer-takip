package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.CommentProjectDto;
import com.batuhansener.stajyerTakip.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentProjectDtoConverter {

    public CommentProjectDto convert(Project project){
        return CommentProjectDto.builder().id(project.getId()).name(project.getName()).score(project.getScore())
                .initialDate(project.getInitialDate()).finishDate(project.getFinishDate()).users(project.getUsers()).build();
    }

}
