package com.yshrestha.cs545.restful.repository;

import com.yshrestha.cs545.restful.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
