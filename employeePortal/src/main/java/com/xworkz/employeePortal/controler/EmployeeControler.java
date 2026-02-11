package com.xworkz.employeePortal.controler;

import com.xworkz.employeePortal.dto.EmployeeDTO;
import com.xworkz.employeePortal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EmployeeControler {

    @Autowired
    EmployeeService employeeService;
    public EmployeeControler(){
        System.out.println("its a controler class");
    }

    @PostMapping("/register")
    public String saveData(EmployeeDTO employeeDTO){
        System.out.println(" controler==="+employeeDTO);

        employeeService.saveValidation(employeeDTO);
        return "registerSuccessfully";
    }
}
