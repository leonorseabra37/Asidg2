package com.asidG1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.asidG1.model.DTOs.ClubDTO;
//import com.asidG1.model.DTOs.StudentDTO;
import com.asidG1.service.ClubService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public ResponseEntity<List<ClubDTO>> getAllClubs() {
        return ResponseEntity.ok(clubService.getAllClubs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubDTO> getClubById(@PathVariable("id") Long clubId) {
        Optional<ClubDTO> club = clubService.getClubById(clubId);
        return club.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClubDTO> addClub(@Valid @RequestBody ClubDTO clubDTO,
                                           UriComponentsBuilder uriComponentsBuilder) {
        long newClubId = clubService.addClub(clubDTO);
        clubDTO.setId(newClubId);
        return ResponseEntity
                .created(uriComponentsBuilder.path("/clubs/{id}").buildAndExpand(newClubId).toUri())
                .body(clubDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClubDTO> updateClubDetails(@Valid @RequestBody ClubDTO clubDTO,
                                                     @PathVariable("id") Long id) {
        ClubDTO updatedClub = clubService.updateClubDetails(id, clubDTO);
        return updatedClub != null ? ResponseEntity.ok(updatedClub) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClubById(@PathVariable("id") Long clubId) {
        clubService.deleteClubById(clubId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ClubDTO>> searchClubsByNameAndCity(@RequestParam(required = false) String name,
                                                                  @RequestParam(required = false) String city) {
        List<ClubDTO> clubs = clubService.searchClubsByNameAndCity(name, city);
        return ResponseEntity.ok(clubs);
    }
}