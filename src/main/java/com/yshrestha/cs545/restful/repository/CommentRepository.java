package com.yshrestha.cs545.restful.repository;

import com.yshrestha.cs545.restful.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {
}
