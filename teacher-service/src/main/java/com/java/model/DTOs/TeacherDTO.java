package com.java.model.DTOs;

import com.java.model.DTOs.base.PersonEntityDTO;

import jakarta.validation.constraints.NotNull;

public class TeacherDTO extends PersonEntityDTO {

    @NotNull
    private SubjectDTO subject;

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }
}
