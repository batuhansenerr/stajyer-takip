package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.ProjectCommentDto;
import com.batuhansener.stajyerTakip.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectCommentDtoConverter {

    private final ProjectUserConverter projectUserConverter;

    public ProjectCommentDto convert(Comment comment){
        return ProjectCommentDto.builder().id(comment.getId())
                .comment(comment.getComment()).user(projectUserConverter.convert(comment.getUser())).releaseDate(comment.getReleaseDate()).build();
    }

}
