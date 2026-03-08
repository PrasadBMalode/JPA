package com.xworkz.crud_Operation.controller;

import com.xworkz.crud_Operation.dto.UserDTO;
import com.xworkz.crud_Operation.service.UserService;
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
public class UserController {

    @Autowired
    UserService userService;

    public UserController() {
        System.out.println("Controller");
    }

    @PostMapping("/registration")
    public String registration(UserDTO userDTO, Model model) {
        String validation = userService.newUserValidation(userDTO);
        if (validation.equalsIgnoreCase("Register Successfully, Data saved in DB")) {
            model.addAttribute("registerDone", validation);
            return "index";
        } else if (validation.equalsIgnoreCase("User already exist...!")) {
            model.addAttribute("exist", validation);
            return "index";
        } else if (validation.equalsIgnoreCase("Registration failed, Please enter valid data...!")) {
            model.addAttribute("failed", validation);
            return "index";
        }
        return "index";
    }

    @GetMapping("/readAllData")
    public String readAllData(Model model) {
        List<UserDTO> userDTOS = userService.readAllDataValidation();
        model.addAttribute("dto", userDTOS);
        return "allUsersData";

    }

    @GetMapping("/fetchingData")
    public String fetchingData(@RequestParam Integer id, Model model){
        UserDTO userDTO = userService.fetchingDTO(id);
        if (userDTO!=null) {
            model.addAttribute("userDTO", userDTO);
            return "updateUserData";
        }
        return "index";
    }

    @PostMapping("/update")
    public String updatingUserData(UserDTO userDTO,Model model){
        userService.updateValidation(userDTO);
        List<UserDTO> userDTOS = userService.readAllDataValidation();
        model.addAttribute("dto", userDTOS);
        return "allUsersData";
    }

    @GetMapping("/delteUser")
    public String deletingUserData(@RequestParam Long phNumber, Model model){
        userService.deletingDataValidation(phNumber);
        List<UserDTO> userDTOS = userService.readAllDataValidation();
        model.addAttribute("dto", userDTOS);
        return "allUsersData";
    }
}
