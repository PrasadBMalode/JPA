package com.xworkz.customerPortal.controler;

import com.xworkz.customerPortal.dto.CustomerPortalDTO;
import com.xworkz.customerPortal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CustomerPortalControler {

    @Autowired
    CustomerService customerService;

    public CustomerPortalControler(){
        System.out.println("its controler class");
    }

    @PostMapping("/register")
    public String customerRegistration(CustomerPortalDTO customerPortalDTO){

        System.out.println("controler==="+customerPortalDTO);

        customerService.saveValidation(customerPortalDTO);
        return "registerSuccessfully";
    }

}
