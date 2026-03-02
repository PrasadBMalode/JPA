package com.xworkz.cru_Operation_Two.service;

import com.xworkz.cru_Operation_Two.dto.StudentDTO;

import java.util.List;


public interface StudentService {

     String studentSaveValidation(StudentDTO studentDTO);

     StudentDTO checkingExistStudentDetailsByNumber(Long contactNumber);

     List<StudentDTO> fetchingStudentDataValidation();

     StudentDTO updateValidationByID(Integer id);


}
