package com.xworkz.readData.controler;

import com.xworkz.readData.dto.ReadDataDTO;
import com.xworkz.readData.service.ReadDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadDataControler {

    @Autowired
    ReadDataService readDataService;


    public ReadDataControler() {
        System.out.println("its a controler class...");
    }

    @PostMapping("/readData")
    public String readData(Model model) {
        List<ReadDataDTO> readDataDTOS = readDataService.readDTO();

        model.addAttribute("dtos",readDataDTOS);



        return "ReadDataPage";

    }
}
