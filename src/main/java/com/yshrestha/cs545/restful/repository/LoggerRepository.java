package com.yshrestha.cs545.restful.repository;

import com.yshrestha.cs545.restful.entity.aop.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long> {
}
