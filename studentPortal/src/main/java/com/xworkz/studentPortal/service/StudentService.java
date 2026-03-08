package com.xworkz.studentPortal.service;


import com.xworkz.studentPortal.dto.StudentDTO;

import java.util.List;


public interface StudentService {

    String saveData(StudentDTO studentDTO);

    List<StudentDTO> getDtos();

   StudentDTO getTraineeInServiceBasedOnEmail(String traineeEmail);

   StudentDTO getTrainee(int id);

   void updateData(StudentDTO studentDTO);

   void deleteData(String email);

}
