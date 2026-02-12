package com.xworkz.facultyPortal.repository;

import com.xworkz.facultyPortal.entity.FacultyEntity;
import org.springframework.stereotype.Repository;

@Repository
public class FacultyRepositoryImpl implements FacultyRepository {
    @Override
    public void saveDB(FacultyEntity facultyEntity) {
        System.out.println("repository===" + facultyEntity);
    }
}
