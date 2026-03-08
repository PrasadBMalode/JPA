package com.xworkz.studentPortal.service;

import com.xworkz.studentPortal.dao.StudentDAO;
import com.xworkz.studentPortal.dto.StudentDTO;
import com.xworkz.studentPortal.entity.StudentEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentDAO studentDAO;

    @Override
    public String saveData(StudentDTO studentDTO) {
        System.out.println("data in service========="+studentDTO);
        StudentDTO dto = getTraineeInServiceBasedOnEmail(studentDTO.getEmail());

        if (dto==null ){
            StudentEntity studentEntity = new StudentEntity();
            BeanUtils.copyProperties(studentDTO, studentEntity);
            if(studentDAO.save(studentEntity)){
                return "Registered successfully";
            }
            return "Not Registered";

        }
        return "Data already exits";
    }

    @Override
    public List<StudentDTO> getDtos() {

        List<StudentEntity> studentEntities=studentDAO.getTraineeData();
        if (!studentEntities.isEmpty()) {
            List<StudentDTO> studentDTOS = new ArrayList<>();

            studentEntities.forEach(studentEntity -> {

                StudentDTO dto = new StudentDTO();
                BeanUtils.copyProperties(studentEntity,dto);

                studentDTOS.add(dto);
            });

            return studentDTOS;
        }else {
            return Collections.emptyList();
        }
    }

    @Override
    public StudentDTO getTraineeInServiceBasedOnEmail(String traineeEmail) {
        StudentEntity studentEntity = studentDAO.getTraineeBasedOnEmail(traineeEmail);

        if (studentEntity!=null){
            StudentDTO dto=new StudentDTO();
            BeanUtils.copyProperties(studentEntity,dto);
            return dto;
        }
        return null;
    }

    @Override
    public StudentDTO getTrainee(int id) {
        if (id!=0) {
            StudentEntity studentEntity = studentDAO.getTraineeBasedOnId(id);
            StudentDTO studentDTO = new StudentDTO();
            BeanUtils.copyProperties(studentEntity, studentDTO);
            return studentDTO;
        }
        return null;
    }

    @Override
    public void updateData(StudentDTO studentDTO) {
        StudentEntity studentEntity=new StudentEntity();
        BeanUtils.copyProperties(studentDTO,studentEntity);
        studentDAO.uodateTrainee(studentEntity);
    }

    @Override
    public void deleteData(String email) {
        studentDAO.delete(email);
    }
}
