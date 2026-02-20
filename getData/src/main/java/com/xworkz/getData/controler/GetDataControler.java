package com.xworkz.getData.controler;

import com.xworkz.getData.dto.GetDataDTO;
import com.xworkz.getData.service.GetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class GetDataControler {

    @Autowired
    GetDataService getDataService;

    public GetDataControler() {
        System.out.println("its controler class...");
    }

    @PostMapping("/readAll")
    public String getDataControler(Model model) {

        List<GetDataDTO> getDataDTOList = getDataService.readAllData();

        System.out.println("controler===" + getDataDTOList);

        model.addAttribute("dtolist", getDataDTOList);
        return "GetDataPage";

    }


}
