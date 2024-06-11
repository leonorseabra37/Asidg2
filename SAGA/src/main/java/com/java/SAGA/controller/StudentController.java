package com.java.SAGA.controller;

import java.util.List;

import com.java.SAGA.model.DTOs.StudentWithParentDTO;
import com.java.SAGA.model.DTOs.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.java.SAGA.model.DTOs.StudentRegisterDTO;
import com.java.SAGA.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentRegisterDTO> addStudent(@Valid @RequestBody StudentDTO studentDTO,
                                                         UriComponentsBuilder uriComponentsBuilder) {

        ResponseEntity<StudentRegisterDTO> newStudentId = studentService.registarEstudante(studentDTO);

        return newStudentId;
    }

    @GetMapping("/large-cities")
    public ResponseEntity<List<StudentWithParentDTO>> getStudentsAndParentsInLargeCities() {
        List<StudentWithParentDTO> studentsWithParents = studentService.getStudentsAndParentsInLargeCities();
        return ResponseEntity.ok(studentsWithParents);
    }
}