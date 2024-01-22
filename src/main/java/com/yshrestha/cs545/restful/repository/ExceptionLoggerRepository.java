package com.yshrestha.cs545.restful.repository;

import com.yshrestha.cs545.restful.entity.aop.ExceptionLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionLoggerRepository extends JpaRepository<ExceptionLogger, Long> {
}
