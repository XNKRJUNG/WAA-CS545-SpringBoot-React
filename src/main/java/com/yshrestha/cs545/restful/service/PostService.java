package com.yshrestha.cs545.restful.service;

import com.yshrestha.cs545.restful.entity.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getPosts();

    PostDTO getPost(Long productId);

    PostDTO save(Long userId, PostDTO post);

}
