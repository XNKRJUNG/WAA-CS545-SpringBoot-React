package com.yshrestha.cs545.restful.entity.dto;

import com.yshrestha.cs545.restful.entity.Comments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private long id;
    private String title;
    private String content;
    private String author;
    private Collection<Comments> comments;
}
