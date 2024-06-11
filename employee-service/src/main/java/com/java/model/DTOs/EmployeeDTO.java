package com.java.model.DTOs;

import jakarta.validation.constraints.*;

import com.java.model.DTOs.base.PersonEntityDTO;
import com.java.model.validation.ValidDepartment;

public class EmployeeDTO extends PersonEntityDTO {

    @NotBlank
    private String jobTitle;

    @Positive
    @Min(6)
    @Max(8)
    private int workHours;

    @NotNull
    @ValidDepartment
    private DepartmentDTO department;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }
}
