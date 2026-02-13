package com.xworkz.customerPortal.service;

import com.xworkz.customerPortal.dao.CustomerDAO;
import com.xworkz.customerPortal.dto.CustomerPortalDTO;
import com.xworkz.customerPortal.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    CustomerDAO customerDAO;

    @Override
    public void saveValidation(CustomerPortalDTO customerPortalDTO) {

        System.out.println("service===" + customerPortalDTO);

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCustomerAge(customerPortalDTO.getCustomerAge());
        customerEntity.setCustomerName(customerPortalDTO.getCustomerName());
        customerEntity.setCustomerLocation(customerPortalDTO.getCustomerLocation());
        customerEntity.setCustomerReview(customerPortalDTO.getCustomerReview());
        customerEntity.setCustomerNumber(customerPortalDTO.getCustomerNumber());

        customerDAO.saveDB(customerEntity);


    }
}
