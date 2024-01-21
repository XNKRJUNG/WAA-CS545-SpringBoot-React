package com.yshrestha.cs545.restful.controller;

import com.yshrestha.cs545.restful.entity.dto.PostDTO;
import com.yshrestha.cs545.restful.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> getPosts() {
        try {
            return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable long postId) {
        try {
            return new ResponseEntity<>(postService.getPost(postId), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<PostDTO> save(@PathVariable long userId, @RequestBody PostDTO post) {
        try {
            return new ResponseEntity<>(postService.save(userId, post), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PostDTO>> getAllPostsByTitle(@RequestParam(value = "title", required = false) String title){
        List<PostDTO> posts = postService.getPostByTitle(title);
        return ResponseEntity.ok(posts);
    }
}
