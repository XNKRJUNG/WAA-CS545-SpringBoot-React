package com.yshrestha.cs545.restful.service.implementation;

import com.yshrestha.cs545.restful.entity.Users;
import com.yshrestha.cs545.restful.entity.dto.PostDTO;
import com.yshrestha.cs545.restful.entity.dto.UserDTO;
import com.yshrestha.cs545.restful.repository.PostRepository;
import com.yshrestha.cs545.restful.repository.UserRepository;
import com.yshrestha.cs545.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> new UserDTO(u.getId(), u.getName(), u.getPosts()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Users userObj = userRepository.findById(userId).get();
        return new UserDTO(userObj.getId(), userObj.getName(), userObj.getPosts());
    }

    @Override
    public UserDTO save(UserDTO user) {
        Users userObj = new Users();
        userObj.setId(user.getId());
        userObj.setName(user.getName());
        userObj.setPosts(user.getPosts());
        userRepository.save(userObj);

        user.setId(userObj.getId());
        return user;
    }

    @Override
    public List<PostDTO> getPostsByUserId(Long userId) {
        return postRepository.findPostsByUserId(userId)
                .stream()
                .map(p -> new PostDTO(p.getId(), p.getTitle(), p.getContent(), p.getAuthor()))
                .collect(Collectors.toList());
    }

}
