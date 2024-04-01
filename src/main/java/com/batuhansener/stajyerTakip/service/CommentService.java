package com.batuhansener.stajyerTakip.service;

import com.batuhansener.stajyerTakip.dto.response.CommentDto;
import com.batuhansener.stajyerTakip.dto.converter.CommentDtoConverter;
import com.batuhansener.stajyerTakip.dto.request.CreateCommentRequest;
import com.batuhansener.stajyerTakip.dto.request.UpdateCommentRequest;
import com.batuhansener.stajyerTakip.exception.CommentNotFoundException;
import com.batuhansener.stajyerTakip.model.Comment;
import com.batuhansener.stajyerTakip.model.Project;
import com.batuhansener.stajyerTakip.model.User;
import com.batuhansener.stajyerTakip.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ProjectService projectService;
    private final CommentRepository commentRepository;
    private final CommentDtoConverter commentDtoConverter;
    private final UserService userService;


    public CommentDto create(CreateCommentRequest request){
        Project project = projectService.findProjectById(request.project_id());
        User user = userService.findAuthenticatedUser();
        Comment comment = Comment.builder().comment(request.comment()).project(project).releaseDate(LocalDateTime.now())
                .user(user).build();
        comment = commentRepository.save(comment);
        projectService.addProjectComment(project, comment);
        return commentDtoConverter.convert(comment);
    }

    public CommentDto update(String id, UpdateCommentRequest request) {
        User user = userService.findAuthenticatedUser();
        Comment comment = findCommentById(id);
        if (isValidUser(user, comment)){
            comment.setComment(request.comment());
            comment.setReleaseDate(LocalDateTime.now());
            commentRepository.save(comment);
        }else {
            throw new RuntimeException("bu yorumu düzeneleme yetkiniz yok");
        }
        return commentDtoConverter.convert(comment);
    }

    public void delete(String id) {
        User user = userService.findAuthenticatedUser();
        Comment comment = findCommentById(id);
        System.out.println(comment);
        if (isValidUser(user, comment)) {
            System.out.println("valid");
//            user.getComments().remove(comment);
//            userService.genericUpdateUser(user);
            projectService.deleteProjectComment(comment);
            commentRepository.delete(comment);
        }
    }

    public Boolean isValidUser(User user, Comment comment){
        if (comment.getUser().getId().equals(user.getId())){
            return true;
        }return false;
    }

    public Comment findCommentById(String id){
        return commentRepository.findById(id).orElseThrow(()->new CommentNotFoundException("yorum yok"));
    }

    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(commentDtoConverter::convert).collect(Collectors.toList());
    }
}
