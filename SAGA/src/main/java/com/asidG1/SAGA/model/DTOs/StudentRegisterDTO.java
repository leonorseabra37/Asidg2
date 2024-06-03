package com.asidG1.SAGA.model.DTOs;

import java.time.LocalDate;

import com.asidG1.SAGA.model.DTOs.base.PersonEntityDTO;

public class StudentRegisterDTO extends PersonEntityDTO{
    private final LocalDate enrollDate = LocalDate.now();

    private Long parent;

    private Long club;

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Long getClub() {
        return club;
    }

    public void setClub(Long club) {
        this.club = club;
    }
}
