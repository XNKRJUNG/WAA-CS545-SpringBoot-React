package com.yshrestha.cs545.restful.repository;

import com.yshrestha.cs545.restful.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository <Posts, Long>{

    @Query(value = "select * from posts p where p.user_id=:userId ", nativeQuery = true)
    List<Posts> findPostsByUserId(@Param("userId") long userId);

}
