package com.yshrestha.cs545.restful.controller;

import com.yshrestha.cs545.restful.entity.dto.PostDTO;
import com.yshrestha.cs545.restful.entity.dto.UserDTO;
import com.yshrestha.cs545.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable long userId) {
        return userService.getUserById(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDTO save(@RequestBody UserDTO user) {
        return userService.save(user);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/{userId}/posts")
    public List<PostDTO> getPostsByUserId(@PathVariable long userId) {
        return userService.getPostsByUserId(userId);
    }

}
