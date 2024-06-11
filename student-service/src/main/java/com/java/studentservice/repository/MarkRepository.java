package com.java.studentservice.repository;

import com.java.studentservice.model.entity.Mark;
import com.java.studentservice.model.entity.enums.MarkEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {

    Mark findByMark(MarkEnum mark);
}
