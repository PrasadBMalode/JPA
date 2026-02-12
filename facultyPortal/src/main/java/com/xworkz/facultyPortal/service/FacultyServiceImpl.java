package com.xworkz.facultyPortal.service;

import com.xworkz.facultyPortal.dto.FacultyDTO;
import com.xworkz.facultyPortal.entity.FacultyEntity;
import com.xworkz.facultyPortal.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public void saveValidation(FacultyDTO facultyDTO) {

        System.out.println("DTO service===" + facultyDTO);

        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setAge(facultyDTO.getAge());
        facultyEntity.setName(facultyDTO.getName());
        facultyEntity.setCllgName(facultyDTO.getCllgName());
        facultyEntity.setPhNumber(facultyDTO.getPhNumber());


        facultyRepository.saveDB(facultyEntity);


    }
}
