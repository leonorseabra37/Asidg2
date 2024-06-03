package com.asidG1.studentservice.model.entity;

import com.asidG1.studentservice.model.entity.base.BasePersonEntity;
import com.asidG1.studentservice.model.entity.enums.MarkEnum;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "students")
public class Student extends BasePersonEntity {

    //@ManyToOne
    private Long parent;
    private Long club;

   /* @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "students_clubs",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "club_id", referencedColumnName = "id")
    )
    private Set<Club> clubs;*/

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "students_marks",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "mark_id", referencedColumnName = "id")
    )
    private List<Mark> marks;

    @Column(name = "enroll_date", nullable = false)
    private LocalDate enrollDate;

    public Student() {
        //this.clubs = new HashSet<>();
        this.marks = new ArrayList<>();
    }

    /*public Set<Club> getClubs() {
        return Collections.unmodifiableSet(clubs);
    }*/

    public List<Mark> getMarks() {
        return Collections.unmodifiableList(marks);
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Long getClub() {
        return club;
    }

    public void setClub(Long club) {
        this.club = club;
    }

    public void addMark(Mark mark) {
        marks.add(mark);
    }

    /*public void addClub(Club club) {
        clubs.add(club);
    }*/

    /*public void removeClub(Club club) {
        clubs.remove(club);
    }*/

    public void removeParent() {
        this.parent = null;
    }
}

