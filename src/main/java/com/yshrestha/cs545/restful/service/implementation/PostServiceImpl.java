package com.yshrestha.cs545.restful.service.implementation;

import com.yshrestha.cs545.restful.entity.Posts;
import com.yshrestha.cs545.restful.entity.Users;
import com.yshrestha.cs545.restful.entity.dto.PostDTO;
import com.yshrestha.cs545.restful.repository.PostRepository;
import com.yshrestha.cs545.restful.repository.UserRepository;
import com.yshrestha.cs545.restful.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PostDTO> getPosts() {
        return postRepository.findAll()
                .stream()
                .map(p -> new PostDTO(p.getId(), p.getTitle(), p.getContent(), p.getAuthor()))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO getPost(Long postId) {
        Posts postRepoObj = postRepository.findById(postId).get();
        return new PostDTO(postRepoObj.getId(), postRepoObj.getTitle(), postRepoObj.getContent(), postRepoObj.getAuthor());
    }

    @Override
    public PostDTO save(Long userId, PostDTO post) {

        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User doesn't exist. Please check the userId and try again."));

        Posts postRepoObj = new Posts();
        postRepoObj.setTitle(post.getTitle());
        postRepoObj.setAuthor(post.getAuthor());
        postRepoObj.setContent(post.getContent());
        // postRepository.save(postRepoObj);

        user.addPost(postRepoObj);
        userRepository.save(user);

        // post.setId(postRepoObj.getId());
//        return post;
        return new PostDTO(postRepoObj.getId(), postRepoObj.getTitle(), postRepoObj.getContent(), postRepoObj.getAuthor());
    }

}
