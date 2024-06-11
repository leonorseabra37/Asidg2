package com.java.studentservice.model.DTOs;

import com.java.studentservice.model.DTOs.base.PersonEntityDTO;

import java.time.LocalDate;

public class StudentDTO extends PersonEntityDTO {

    private final LocalDate enrollDate = LocalDate.now();

    private Long parent;

    private Long club;

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public Long getParent() {
        return parent;
    }

    public Long getClub() {
        return club;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public void setClub(Long club) {
        this.club = club;
    }
}


