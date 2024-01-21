package com.yshrestha.cs545.restful.service;

import com.yshrestha.cs545.restful.entity.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> getComments();

    CommentDTO getCommentById(Long commentId);

    CommentDTO save(Long postId, CommentDTO commentObj);
}
