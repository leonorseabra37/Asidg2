package com.java.SAGA.model.DTOs;

public class StudentWithParentDTO {

    private StudentDTO student;
    private ParentDTO parent;

    // Getters and Setters

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
    }
}
