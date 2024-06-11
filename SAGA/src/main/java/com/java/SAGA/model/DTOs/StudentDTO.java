package com.java.SAGA.model.DTOs;

import java.time.LocalDate;

import com.java.SAGA.model.DTOs.base.PersonEntityDTO;

public class StudentDTO extends PersonEntityDTO{
    private final LocalDate enrollDate = LocalDate.now();

    private ParentDTO parent;

    private ClubDTO club;

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public ParentDTO getParent() {
        return parent;
    }

    public ClubDTO getClub() {
        return club;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
    }

    public void setClub(ClubDTO club) {
        this.club = club;
    }
}

