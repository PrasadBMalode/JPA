package com.xworkz.trip.controler;

import com.xworkz.trip.dto.TripDTO;
import com.xworkz.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class TripControler {

    @Autowired
    TripService tripService;

    public TripControler() {
        System.out.println("its a controler class...");
    }

    @PostMapping("/register")
    public String studentRegister(TripDTO tripDTO, Model model) {

        String validation = tripService.studetValidation(tripDTO);

        if (validation.equalsIgnoreCase("Register Successfully done")) {
            model.addAttribute("success", validation);
            return "index";
        } else if (validation.equalsIgnoreCase("Register failed in DB...!")) {
            model.addAttribute("dbWrong", validation);
            return "index";
        } else if (validation.equalsIgnoreCase("Not Registered")) {
            model.addAttribute("errorMsg", validation);
            return "index";
        } else {
            model.addAttribute("errorMsg", validation);
            return "index";
        }
    }

    @PostMapping("/readData")
    public String readallData(Model model) {

        List<TripDTO> tripDTOS = tripService.readAllData();
        model.addAttribute("tripDtos", tripDTOS);
        return "readAllDataPage";
    }

    @GetMapping("/readData")
    public String readStudentData(@RequestParam Integer id,Model model){
        TripDTO tripDTO = tripService.getStudentByID(id);
        if (tripDTO!=null){
            model.addAttribute("byId",tripDTO);
            return "readStudentData";
        }

        return "index";
    }
}
