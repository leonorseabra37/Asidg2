package com.asidG1.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asidG1.model.DTOs.ClubDTO;
import com.asidG1.model.entity.Club;
import com.asidG1.repository.ClubRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubService {

    private final ClubRepository clubRepository;
    private final ModelMapper mapper;

    @Autowired
    public ClubService(ClubRepository clubRepository, ModelMapper mapper) {
        this.clubRepository = clubRepository;
        this.mapper = mapper;
    }

    private ClubDTO mapToClubDTO(Club club) {
        ClubDTO clubDTO = new ClubDTO();
        clubDTO.setId(club.getId());
        clubDTO.setName(club.getName());
        clubDTO.setDescription(club.getDescription());
        clubDTO.setCity(club.getCity());
        clubDTO.setPopulation(club.getPopulation());
        return clubDTO;
    }


    public ClubDTO findClubByName(String name) {
        Club club = clubRepository.findByName(name);
        return club != null ? mapToClubDTO(club) : null;
    }

    public List<ClubDTO> getAllClubs() {
        return clubRepository.findAll()
                .stream()
                .map(this::mapToClubDTO)
                .toList();
    }

    public Optional<ClubDTO> getClubById(Long clubId) {
        return clubRepository.findById(clubId).map(this::mapToClubDTO);
    }

    @Transactional
    public void deleteClubById(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    public long addClub(ClubDTO clubDTO) {
        Club club = mapper.map(clubDTO, Club.class);
        clubRepository.save(club);
        return club.getId();
    }

    public ClubDTO updateClubDetails(Long id, ClubDTO clubDTO) {
        Optional<Club> optionalClub = clubRepository.findById(id);
        if (optionalClub.isPresent()) {
            Club club = optionalClub.get();
            club.setName(clubDTO.getName());
            club.setCity(clubDTO.getCity());
            club.setPopulation(clubDTO.getPopulation());
            clubRepository.save(club);
            return mapToClubDTO(club);
        }
        return null;
    }

    public List<ClubDTO> searchClubsByNameAndCity(String name, String city) {
        if (name != null && city != null) {
            return clubRepository.findByNameAndCityContainingIgnoreCase(name, city)
                    .stream()
                    .map(this::mapToClubDTO)
                    .toList();
        } else if (name != null) {
            return clubRepository.findByNameContainingIgnoreCase(name)
                    .stream()
                    .map(this::mapToClubDTO)
                    .toList();
        } else if (city != null) {
            return clubRepository.findByCityContainingIgnoreCase(city)
                    .stream()
                    .map(this::mapToClubDTO)
                    .toList();
        } else {
            return getAllClubs();


        }
    }

    public List<ClubDTO> findClubsInLargeCities() {
        List<Club> clubs = clubRepository.findClubsInLargeCities();
        return clubs.stream().map(this::mapToClubDTO).collect(Collectors.toList());
    }

}
