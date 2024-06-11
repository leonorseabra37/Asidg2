package com.java.model.validation;

import com.java.model.DTOs.TownDTO;
import com.java.repository.TownRepository;
import jakarta.validation.*;

import org.springframework.beans.factory.annotation.Autowired;

public class ValidTownValidator implements ConstraintValidator<ValidTown, TownDTO> {

    private final TownRepository townRepository;

    @Autowired
    public ValidTownValidator(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public boolean isValid(TownDTO town, ConstraintValidatorContext context) {
        return
                townRepository
                        .findById(town.getId())
                        .isPresent();
    }
}
