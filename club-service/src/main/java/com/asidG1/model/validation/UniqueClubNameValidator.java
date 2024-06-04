package com.asidG1.model.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.asidG1.repository.ClubRepository;

import jakarta.validation.*;

public class UniqueClubNameValidator implements ConstraintValidator<UniqueClubName, String> {

    private final ClubRepository clubRepository;

    @Autowired
    public UniqueClubNameValidator(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public boolean isValid(String clubName, ConstraintValidatorContext context) {
        return clubRepository.findByName(clubName) == null;
    }
}