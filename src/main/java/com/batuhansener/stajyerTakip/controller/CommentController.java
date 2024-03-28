package com.batuhansener.stajyerTakip.controller;

import com.batuhansener.stajyerTakip.dto.CommentDto;
import com.batuhansener.stajyerTakip.dto.request.CreateCommentRequest;
import com.batuhansener.stajyerTakip.model.Comment;
import com.batuhansener.stajyerTakip.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/addNewComment")
    public ResponseEntity<CommentDto> createComment(@RequestBody CreateCommentRequest request){
        return ResponseEntity.ok(commentService.create(request));
    }
}
