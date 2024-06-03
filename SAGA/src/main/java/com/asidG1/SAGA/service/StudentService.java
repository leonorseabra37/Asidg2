
package com.asidG1.SAGA.service;

import com.asidG1.SAGA.feignclient.ClubClient;
import com.asidG1.SAGA.feignclient.ParentClient;
import com.asidG1.SAGA.feignclient.StudentClient;
import com.asidG1.SAGA.model.DTOs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@Service
public class StudentService {

    @Autowired
    private ParentClient parentClient;

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private ClubClient clubClient;



    // Registrar estudante com o pai
    public ResponseEntity<StudentRegisterDTO> registarEstudante(StudentDTO studentDTO) {
        ClubDTO clubDTO = findClubById(studentDTO.getClub().getId());

        if (clubDTO == null) {
            throw new RuntimeException("O clube associado ao estudante não está na lista de clubes disponíveis.");
        }

        ResponseEntity<ParentDTO> parentResponse = parentClient.addParent(studentDTO.getParent());
        URI parentUri = parentResponse.getHeaders().getLocation();
        ParentDTO parentToMap = parentResponse.getBody();

        StudentRegisterDTO student = new StudentRegisterDTO();
        student.setAge(studentDTO.getAge());
        student.setEGN(studentDTO.getEGN());
        student.setEmail(studentDTO.getEmail());
        student.setFirstName(studentDTO.getEmail());
        student.setGender(studentDTO.getGender());
        student.setId(studentDTO.getId());
        student.setLastName(studentDTO.getLastName());
        student.setMiddleName(studentDTO.getMiddleName());
        student.setParent(parentToMap.getId());
        student.setClub(studentDTO.getClub().getId());

        ResponseEntity<StudentRegisterDTO> studentRegisterDTO = studentClient.addStudent(student);

        return studentRegisterDTO;
    }

    private ClubDTO findClubById(Long clubId) {
        try {
            ResponseEntity<List<ClubDTO>> clubResponse = clubClient.getAllClubs();
            List<ClubDTO> clubList = clubResponse.getBody();

            if (clubList != null) {
                for (ClubDTO club : clubList) {
                    if (club.getId().equals(clubId)) {
                        return club;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



    public List<StudentWithParentDTO> getStudentsAndParentsInLargeCities() {
        // Fetch all students in large cities
        ResponseEntity<List<StudentWithParentDTO>> studentResponse = studentClient.getStudentsInLargeCities();
        List<StudentWithParentDTO> studentList = studentResponse.getBody();

        // Fetch all parents
        ResponseEntity<List<ParentDTO>> parentResponse = parentClient.getAllParents();
        List<ParentDTO> parentList = parentResponse.getBody();

        // Map parents by their ID for quick lookup
        Map<Long, ParentDTO> parentMap = parentList.stream()
                .collect(Collectors.toMap(ParentDTO::getId, parent -> parent));

        // Combine student and parent data into StudentWithParentDTO
        return studentList.stream()
                .map(student -> {
                    StudentWithParentDTO dto = new StudentWithParentDTO();
                    dto.setStudent(student.getStudent());
                    dto.setParent(parentMap.get(student.getParent()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

}
