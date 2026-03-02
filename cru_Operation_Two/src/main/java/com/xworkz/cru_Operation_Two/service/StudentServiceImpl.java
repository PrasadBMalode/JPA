package com.xworkz.cru_Operation_Two.service;

import com.xworkz.cru_Operation_Two.dao.StudentDAO;
import com.xworkz.cru_Operation_Two.dto.StudentDTO;
import com.xworkz.cru_Operation_Two.entity.StudentEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Override
    public String studentSaveValidation(StudentDTO studentDTO) {

        if (studentDTO.getAge() != null && studentDTO.getAge() > 18 && studentDTO.getAge() < 100 &&

                studentDTO.getName() != null &&
                studentDTO.getName().length() >= 4 &&
                studentDTO.getName().matches("[a-zA-Z ]+") &&

                studentDTO.getCllgName() != null &&
                studentDTO.getCllgName().length() >= 3 &&

                studentDTO.getContactNumber() != null &&
                String.valueOf(studentDTO.getContactNumber()).length() == 10) {

            StudentDTO checkingExistStudentDetailsByNumber = checkingExistStudentDetailsByNumber(studentDTO.getContactNumber());
            if (checkingExistStudentDetailsByNumber == null) {
                StudentEntity studentEntity = new StudentEntity();
                BeanUtils.copyProperties(studentDTO, studentEntity);
                if (studentDAO.studentDetailsSaveToDB(studentEntity)) {
                    return "Registration done, data saved to DB";
                } else {
                    return "Data not save d to DB";
                }
            } else {
                return "student details already exist";
            }
        } else {
            return "Registration failed, enter valid data";
        }

    }

    @Override
    public StudentDTO checkingExistStudentDetailsByNumber(Long contactNumber) {

        StudentEntity studentEntity = studentDAO.fetchingStudentdetailsFromDB(contactNumber);
        if (studentEntity != null) {
            StudentDTO studentDTO = new StudentDTO();
            BeanUtils.copyProperties(studentEntity, studentDTO);
            return studentDTO;
        }

        return null;
    }

    @Override
    public List<StudentDTO> fetchingStudentDataValidation() {

        List<StudentEntity> studentEntities = studentDAO.fetchingAllStudentaDataFromDB();
        if (!studentEntities.isEmpty()) {

            List<StudentDTO> studentDTOS = new ArrayList<>();

            studentEntities.forEach(studentEntity -> {
                StudentDTO studentDTO = new StudentDTO();
                BeanUtils.copyProperties(studentEntity, studentDTO);
                studentDTOS.add(studentDTO);

            });

            return studentDTOS;

        }
        return Collections.emptyList();
    }

    @Override
    public StudentDTO updateValidationByID(Integer id) {
        StudentEntity studentEntity = studentDAO.updatingStudentDataToDB(id);
        if (id != 0) {

            StudentDTO studentDTO=new StudentDTO();
            BeanUtils.copyProperties(studentEntity,studentDTO);
            return studentDTO;
        }
        return null;
    }
}
