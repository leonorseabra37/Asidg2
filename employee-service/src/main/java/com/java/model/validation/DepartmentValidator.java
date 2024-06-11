package com.java.model.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.model.DTOs.DepartmentDTO;
import com.java.repository.DepartmentRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DepartmentValidator implements ConstraintValidator<ValidDepartment, DepartmentDTO> {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentValidator(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public boolean isValid(DepartmentDTO department, ConstraintValidatorContext context) {
        return departmentRepository.findById(department.getId()).isPresent();
    }
}
