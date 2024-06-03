package com.asidG1.SAGA.model.DTOs;

import com.asidG1.SAGA.model.DTOs.base.PersonEntityDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClubDTO extends PersonEntityDTO {

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank
    @Size(min = 5, max = 500)
    private String description;

    @NotBlank
    private String city;

    @NotBlank
    private int population; // Alterado para String

    // Getters e Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}