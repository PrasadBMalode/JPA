package com.xworkz.facultyPortal.controler;

import com.xworkz.facultyPortal.dto.FacultyDTO;
import com.xworkz.facultyPortal.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FacultyControler {

    @Autowired
    FacultyService facultyService;

    public FacultyControler() {
        System.out.println("its a controler class");
    }

    @PostMapping("/register")
    public String saveRegister(FacultyDTO facultyDTO) {
        System.out.println("controler===" + facultyDTO);

        facultyService.saveValidation(facultyDTO);

        return "registerSuccessfully";

    }


}
