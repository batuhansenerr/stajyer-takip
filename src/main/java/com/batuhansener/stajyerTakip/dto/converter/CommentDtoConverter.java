package com.batuhansener.stajyerTakip.dto.converter;

import com.batuhansener.stajyerTakip.dto.CommentDto;
import com.batuhansener.stajyerTakip.dto.ProjectCommentDto;
import com.batuhansener.stajyerTakip.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentDtoConverter {

    private final ProjectDtoConverter projectDtoConverter;
    private final ProjectUserConverter projectUserConverter;

    public CommentDto convert(Comment comment){
        return CommentDto.builder().id(comment.getId())
                .comment(comment.getComment()).user(projectUserConverter.convert(comment.getUser())).releaseDate(comment.getReleaseDate())
                .project(projectDtoConverter.convert(comment.getProject())).build();
    }
}
