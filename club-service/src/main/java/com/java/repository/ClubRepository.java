package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.model.entity.Club;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {


    Club findByName(String clubName);

    List<Club> findByNameAndCityContainingIgnoreCase(String name, String city);

    List<Club> findByNameContainingIgnoreCase(String name);

    List<Club> findByCityContainingIgnoreCase(String city);

    @Query("SELECT c FROM Club c WHERE c.population > :threshold")
    List<Club> findClubsInLargeCities();
}
