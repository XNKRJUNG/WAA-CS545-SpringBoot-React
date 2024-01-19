package com.yshrestha.cs545.restful.entity.dto;

import com.yshrestha.cs545.restful.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private long id;
    private String title;
    private String content;
    private String author;

    public PostDTO(Post post) {
    }
}
