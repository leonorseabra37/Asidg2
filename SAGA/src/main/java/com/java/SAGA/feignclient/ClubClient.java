package com.java.SAGA.feignclient;


import com.java.SAGA.model.DTOs.ClubDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


//http://localhost:8082/clubs/{id}
@FeignClient(name = "CLUB-SERVICE", url = "http://localhost:8082")
 public interface ClubClient {

        @GetMapping("/clubs/{id}")
        ResponseEntity<List<ClubDTO>> getClubById(@PathVariable("id") Long id);

        @GetMapping("/clubs")
        ResponseEntity<List<ClubDTO>> getAllClubs(); // Novo método para obter todos os clubes

        @PostMapping("/clubs")
        ResponseEntity<ClubDTO> addClub(@Valid @RequestBody ClubDTO clubDTO);

}
