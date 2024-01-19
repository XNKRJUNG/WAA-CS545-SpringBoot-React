package com.yshrestha.cs545.restful.service.implementation;

import com.yshrestha.cs545.restful.entity.Post;
import com.yshrestha.cs545.restful.entity.dto.PostDTO;
import com.yshrestha.cs545.restful.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yshrestha.cs545.restful.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostDTO> getPosts() {
        return postRepository.findAll()
                .stream()
                .map(p-> new PostDTO(p.getId(),p.getTitle(),p.getContent(),p.getAuthor()))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO getPost(Long postId) {
        Post postRepoObj = postRepository.findById(postId);
        return new PostDTO(postRepoObj.getId(),postRepoObj.getTitle(),postRepoObj.getContent(),postRepoObj.getAuthor());
    }

    @Override
    public PostDTO save(PostDTO post) {
        Post postRepoObj = new Post(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
        return new PostDTO(postRepoObj.getId(),postRepoObj.getTitle(),postRepoObj.getContent(),postRepoObj.getAuthor());
    }
}
