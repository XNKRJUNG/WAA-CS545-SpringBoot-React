package com.yshrestha.cs545.restful.repository;

import com.yshrestha.cs545.restful.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("SELECT u FROM Users u JOIN u.posts p GROUP BY u HAVING COUNT(p) > :n")
    List<Users> getAllUsersWithMoreThanNPost(@Param("n") int n);
}
