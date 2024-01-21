package com.yshrestha.cs545.restful.service.implementation;

import com.yshrestha.cs545.restful.entity.Comments;
import com.yshrestha.cs545.restful.entity.Posts;
import com.yshrestha.cs545.restful.entity.dto.CommentDTO;
import com.yshrestha.cs545.restful.repository.CommentRepository;
import com.yshrestha.cs545.restful.repository.PostRepository;
import com.yshrestha.cs545.restful.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<CommentDTO> getComments() {
        return commentRepository.findAll()
                .stream()
                .map(c -> new CommentDTO(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO getCommentById(Long commentId) {
        Comments commentRepoObj = commentRepository.findById(commentId).get();
        return new CommentDTO(commentRepoObj.getId(), commentRepoObj.getName());
    }

    @Override
    public CommentDTO save(Long postId, CommentDTO commentObj) {
        System.out.println(commentObj);
        Posts postRepoObj = postRepository.findById(postId).orElseThrow(()->new RuntimeException("Post doesn't exist or this post is not available."));


        Comments newCommentObj = new Comments();
        newCommentObj.setId(commentObj.getId());
        newCommentObj.setName(commentObj.getName());

//        postRepoObj.setComments(newCommentObj);
        System.out.println("newCommentObj" + newCommentObj);
        System.out.println("id:" + commentObj.getId());

        postRepoObj.addComment(newCommentObj);
        postRepository.save(postRepoObj);
        System.out.println(postRepoObj);
//        commentRepository.save(newCommentObj);

        return new CommentDTO(newCommentObj.getId(), newCommentObj.getName());
    }
}
