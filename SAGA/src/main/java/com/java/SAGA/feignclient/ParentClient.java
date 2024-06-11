package com.java.SAGA.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.SAGA.model.DTOs.ParentDTO;

import jakarta.validation.Valid;

import java.util.List;

//http://localhost:8081/parents/{id}
@FeignClient(name = "PARENT-SERVICE", url = "http://localhost:8081")
public interface ParentClient {

    @GetMapping("/parents/{id}")
    ResponseEntity<ParentDTO> getParentById(@PathVariable("id") Long id);

    @PostMapping("/parents")
    ResponseEntity<ParentDTO> addParent(@Valid @RequestBody ParentDTO parentDTO);

    @GetMapping("/parents")
    ResponseEntity<List<ParentDTO>> getAllParents();
}
