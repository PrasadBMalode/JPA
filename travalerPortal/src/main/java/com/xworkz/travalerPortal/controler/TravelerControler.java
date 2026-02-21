package com.xworkz.travalerPortal.controler;

import com.xworkz.travalerPortal.dto.TravalerDTO;
import com.xworkz.travalerPortal.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class TravelerControler {

    @Autowired
    TravelerService travelerService;

    public TravelerControler() {
        System.out.println("its a controler class...");
    }

    @PostMapping("/register")
    public String travelerRegister(TravalerDTO travalerDTO, Model model) {
        System.out.println("controler==" + travalerDTO);

        boolean register = travelerService.registerValidation(travalerDTO);

        if (register) {
            model.addAttribute("valid", "register Sucessfully...!");

        } else {
            model.addAttribute("invalid", "Enter valid data...!");
        }
        return "index";
    }


    @PostMapping("/readAll")
    public String readAllData(Model model) {

        List<TravalerDTO> travalerDTOS = travelerService.readAllData();
        model.addAttribute("dtos",travalerDTOS);
        System.out.println("controler==="+travalerDTOS);
        return "readDB";
    }
}
