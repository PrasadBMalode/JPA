package com.xworkz.studentPortal.dao;

import com.xworkz.studentPortal.entity.StudentEntity;

import java.util.List;

public interface StudentDAO {

    boolean save(StudentEntity studentEntity);

    List<StudentEntity> getTraineeData();

    StudentEntity getTraineeBasedOnEmail(String email);

    StudentEntity getTraineeBasedOnId(int id);

    void uodateTrainee(StudentEntity studentEntity);

    void delete(String email);
}
