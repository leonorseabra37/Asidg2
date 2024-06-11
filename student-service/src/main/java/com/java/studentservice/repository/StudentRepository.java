package com.java.studentservice.repository;

//import com.asidG1.studentservice.model.entity.Club;
import com.java.studentservice.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    //Optional<List<Student>> findByParentId(Long parentId);

    //Optional<List<Student>> findByClubs(Club club);
}
