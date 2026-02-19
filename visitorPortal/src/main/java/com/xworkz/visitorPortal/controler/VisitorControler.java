package com.xworkz.visitorPortal.controler;

import com.xworkz.visitorPortal.dto.VisitorDTO;
import com.xworkz.visitorPortal.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class VisitorControler {

    @Autowired
    VisitorService visitorService;

    @PostMapping("/register")
    public String userRegister(VisitorDTO visitorDTO, Model model) {
        System.out.println("controler===" + visitorDTO);

        boolean register=visitorService.visitorValidation(visitorDTO);



        if (register) {
            model.addAttribute("dto",visitorDTO);
            model.addAttribute("success", "register Successfully...!");

            return "index";
        } else {
            model.addAttribute("invalid", "Please Enter valid data...!");
            return "index";

        }


    }
}
