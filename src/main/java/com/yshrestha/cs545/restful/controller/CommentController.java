package com.yshrestha.cs545.restful.controller;

import com.yshrestha.cs545.restful.entity.dto.CommentDTO;
import com.yshrestha.cs545.restful.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CommentDTO> getComments() {
        return commentService.getComments();
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/{commentId}")
    public CommentDTO getCommentById(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/post/{postId}")
    public CommentDTO save(@PathVariable Long postId, @RequestBody CommentDTO commentObj) {
        return commentService.save(postId, commentObj);
    }
}
