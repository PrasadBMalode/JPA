package com.xworkz.employeePortal.repository;

import com.xworkz.employeePortal.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public void saveDB(EmployeeEntity employeeEntity) {
        System.out.println("Repository===" + employeeEntity);


    }
}
