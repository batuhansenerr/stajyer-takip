package com.batuhansener.stajyerTakip.controller;

import com.batuhansener.stajyerTakip.dto.response.CommentDto;
import com.batuhansener.stajyerTakip.dto.request.CreateCommentRequest;
import com.batuhansener.stajyerTakip.dto.request.UpdateCommentRequest;
import com.batuhansener.stajyerTakip.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResponseEntity<CommentDto> createComment(@RequestBody CreateCommentRequest request){
        return ResponseEntity.ok(commentService.create(request));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody UpdateCommentRequest request, @PathVariable String id){
        return ResponseEntity.ok(commentService.update(id, request));
    }

    @PostMapping("/delete/{id}")
    public void deleteComment(@PathVariable String id){
        commentService.delete(id);
    }
}
