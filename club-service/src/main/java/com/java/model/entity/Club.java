package com.java.model.entity;

import jakarta.persistence.*;

import com.java.model.entity.base.BaseEntityWithIdLong;

@Entity
@Table(name = "clubs")
public class Club extends BaseEntityWithIdLong {

    @Column(unique = true)
    private String name;

    @Column(length = 500, columnDefinition = "text")
    private String description;

    @Column
    private String city;

    @Column
    private int population;



    /*@ManyToMany(mappedBy = "clubs", fetch = FetchType.LAZY)
    private Set<Student> students;*/

    public Club() {
        //this.students = new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    /*public void addStudentToClub(Student student) {
        students.add(student);
    }*/

    /*public void removeStudentFromClub(Student student) {
        students.remove(student);
    }*/

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public int getPopulation() {
        return population;
    }


    /*public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }*/

    @Override
    public String toString() {
        return "Club's name: " + name + System.lineSeparator()
                + "Club's description: " + description;
    }
}
