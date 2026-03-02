package com.xworkz.cru_Operation_Two.dao;

import com.xworkz.cru_Operation_Two.entity.StudentEntity;

import java.util.List;

public interface StudentDAO {

    boolean studentDetailsSaveToDB(StudentEntity studentEntity);

    StudentEntity fetchingStudentdetailsFromDB(Long contactNumber);

    List<StudentEntity> fetchingAllStudentaDataFromDB();

    StudentEntity updatingStudentDataToDB(Integer id);
}
