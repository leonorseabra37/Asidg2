package com.java.SAGA.feignclient;

import com.java.SAGA.model.DTOs.StudentDTO;
import com.java.SAGA.model.DTOs.StudentRegisterDTO;
import com.java.SAGA.model.DTOs.StudentWithParentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import java.util.List;

//http://localhost:8081/parents/{id}
@FeignClient(name = "STUDENT-SERVICE", url = "http://localhost:8084")
public interface StudentClient {

    @GetMapping("/students/{id}")
    ResponseEntity<StudentDTO> getStudentsById(@PathVariable("id") Long id);

    @PostMapping("/students")
    ResponseEntity<StudentRegisterDTO> addStudent(@Valid @RequestBody StudentRegisterDTO studentRegisterDTO);

    @GetMapping("/students")
    ResponseEntity<List<StudentDTO>> getAllStudents();


    @GetMapping("/students/large-cities")
    ResponseEntity<List<StudentWithParentDTO>> getStudentsInLargeCities();
}