package com.yshrestha.cs545.restful.repository;

import com.yshrestha.cs545.restful.entity.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();

    Post findById(long postId);

    void save(Post post);

}
