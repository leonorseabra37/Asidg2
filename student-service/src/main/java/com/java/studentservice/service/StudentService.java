package com.java.studentservice.service;

import com.java.studentservice.model.DTOs.MarkDTO;
import com.java.studentservice.model.DTOs.StudentDTO;
import com.java.studentservice.model.entity.Mark;
//import com.asidG1.studentservice.model.entity.Parent;
import com.java.studentservice.model.entity.Student;
//import com.asidG1.studentservice.model.entity.Town;
import com.java.studentservice.repository.MarkRepository;
import com.java.studentservice.repository.StudentRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final MarkRepository markRepository;

    //private final TownService townService;

    //private final ParentService parentService;

    private final ModelMapper mapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, MarkRepository markRepository, /*TownService townService, ParentService parentService,*/ ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.markRepository = markRepository;
        //this.townService = townService;
        //this.parentService = parentService;
        this.mapper = mapper;
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(this::mapToStudentDTO)
                .toList();
    }

    public Optional<StudentDTO> getStudentById(Long studentId) {
        return studentRepository
                .findById(studentId)
                .map(this::mapToStudentDTO);
    }

    public long addStudent(StudentDTO studentDTO) {
        //Town townToMap = townService.findByTownId(studentDTO.getTown().getId());

        /*Parent parentToMap = parentService.findParentById(studentDTO.getParent() != null
                ? studentDTO.getParent().getId()
                : 0);*/

        Student student = mapper.map(studentDTO, Student.class);

        //student.setTown(townToMap);
        //student.setParent(parentToMap);

        studentRepository.save(student);

        return student.getId();
    }

    public boolean addMarkToStudent(Long studentId, MarkDTO markDTO) {
        Mark markToAdd = markRepository.findByMark(markDTO.getMark());
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.addMark(markToAdd);
            studentRepository.save(student);
            return true;
        }

        return false;
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    private StudentDTO mapToStudentDTO(Student student) {
        return mapper.map(student, StudentDTO.class);
    }
}
