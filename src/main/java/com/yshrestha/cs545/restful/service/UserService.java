package com.yshrestha.cs545.restful.service;

import com.yshrestha.cs545.restful.entity.dto.PostDTO;
import com.yshrestha.cs545.restful.entity.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO getUserById(Long userId);

    UserDTO save(UserDTO user);

    List<PostDTO> getPostsByUserId(Long userId);

}
