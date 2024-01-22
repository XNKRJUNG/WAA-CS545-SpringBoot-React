package com.yshrestha.cs545.restful.entity.aop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class ExceptionLogger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    private String principal;
    private String operation;
    private String exceptionType;
    private String exceptionMessage;
}
