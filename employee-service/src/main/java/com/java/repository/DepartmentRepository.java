package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.model.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {


}
