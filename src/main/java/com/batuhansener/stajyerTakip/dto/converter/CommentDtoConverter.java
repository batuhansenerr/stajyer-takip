package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.CommentProjectDto;
import com.batuhansener.stajyerTakip.dto.response.CommentDto;
import com.batuhansener.stajyerTakip.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentDtoConverter {

    private final ProjectUserConverter projectUserConverter;
    private final CommentProjectDtoConverter commentProjectDtoConverter;

    public CommentDto convert(Comment comment){
        return CommentDto.builder().id(comment.getId())
                .comment(comment.getComment()).user(projectUserConverter.convert(comment.getUser())).releaseDate(comment.getReleaseDate())
                .project(commentProjectDtoConverter.convert(comment.getProject())).build();
    }
}
