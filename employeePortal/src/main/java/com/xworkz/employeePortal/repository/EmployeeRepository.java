package com.xworkz.employeePortal.repository;

import com.xworkz.employeePortal.entity.EmployeeEntity;

public interface EmployeeRepository {

    public abstract void saveDB(EmployeeEntity employeeEntity);
}
