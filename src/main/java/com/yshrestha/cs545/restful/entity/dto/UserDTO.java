package com.yshrestha.cs545.restful.entity.dto;

import com.yshrestha.cs545.restful.entity.Posts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String name;
    private List<Posts> posts;
}
