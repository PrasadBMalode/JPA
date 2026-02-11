package com.xworkz.employeePortal.service;

import com.xworkz.employeePortal.dto.EmployeeDTO;
import com.xworkz.employeePortal.entity.EmployeeEntity;
import com.xworkz.employeePortal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public void saveValidation(EmployeeDTO employeeDTO) {
        System.out.println("service package===" + employeeDTO);

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAge(employeeDTO.getAge());
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setCompanyName(employeeDTO.getCompanyName());
        employeeEntity.setPhNumber(employeeDTO.getPhNumber());

        employeeRepository.saveDB(employeeEntity);
    }
}
