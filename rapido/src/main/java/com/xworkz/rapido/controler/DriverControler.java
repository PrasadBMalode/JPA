package com.xworkz.rapido.controler;

import com.xworkz.rapido.dto.DriverDTO;
import com.xworkz.rapido.service.DriverService;
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
public class DriverControler {

    @Autowired
    DriverService driverService;

    public DriverControler() {
        System.out.println("its controler class...");
    }

    @PostMapping("/register")
    public String Registration(DriverDTO driverDTO, Model model) {
        String validation = driverService.registrationValidationForSaveToDB(driverDTO);
        if (validation.equalsIgnoreCase("Registeration Done, Data saved to DB")) {
            model.addAttribute("savedDB", validation);
            return "index";
        } else if (validation.equalsIgnoreCase("Not Registered, Enter valid Data")) {
            model.addAttribute("registerFail", validation);
            return "index";
        } else if (validation.equalsIgnoreCase("Driver Details Already Exist bro")) {
            model.addAttribute("existData", validation);
            return "index";
        }
        return "index";
    }

    @GetMapping("/fetchData")
    public String fetchingAllDataListFromDB(Model model) {
        List<DriverDTO> driverDTOS = driverService.fetchingDataValidation();
        model.addAttribute("driverDTOS", driverDTOS);
        return "fetchedData";
    }

    @GetMapping("/fetchingForUpdate")
    public String updatDriverDetails(@RequestParam Integer id, Model model) {
        DriverDTO driverDTO = driverService.findAndFetchDriverValidation(id);
        if (driverDTO != null) {
            model.addAttribute("byID", driverDTO);
            return "updateForm";
        }
        return "index";
    }
}
