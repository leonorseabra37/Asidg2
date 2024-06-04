package com.asidG1.model.DTOs;

import jakarta.validation.*;


import com.asidG1.model.entity.base.BaseEntityWithIdLong;
import com.asidG1.model.validation.UniqueClubName;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClubDTO extends BaseEntityWithIdLong {

    @NotBlank
    @Size(min = 2, max = 20)
    @UniqueClubName
    private String name;

    @NotBlank
    @Size(min = 5, max = 500)
    private String description;


    @NotBlank(message = "City must not be blank")
    @Size(min = 5, max = 500)
    private String city;

    @Min(0)
    @Max(999999)
    private int population;
    // Getters e Setters para os novos campos (city e population)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}