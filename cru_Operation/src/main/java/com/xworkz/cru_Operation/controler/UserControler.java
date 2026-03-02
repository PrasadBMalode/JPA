package com.xworkz.cru_Operation.controler;

import com.xworkz.cru_Operation.dto.UserDTO;
import com.xworkz.cru_Operation.service.UserService;
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
public class UserControler {

    @Autowired
    UserService userService;

    public UserControler() {
        System.out.println("its a controler class...");
    }

    @PostMapping("/register")
    public String registration(UserDTO userDTO, Model model) {

        String validation = userService.userValidation(userDTO);

        if (validation.equalsIgnoreCase("Registration Done, User Data Saved to Db")) {
            model.addAttribute("savedDB", validation);
            return "index";
        } else if (validation.equalsIgnoreCase("User Data failed to save")) {
            model.addAttribute("failedToSave", validation);
            return "index";
        } else if (validation.equalsIgnoreCase("User Details alredy exist in DataBase")) {
            model.addAttribute("existUser", validation);
            return "index";
        } else if (validation.equalsIgnoreCase("Enter valid User Details")) {
            model.addAttribute("notValidData", validation);
            return "index";
        }
        return "index";
    }

    @GetMapping("/fetchData")
    public String fetchingAllUsersFromDB(Model model) {

        List<UserDTO> allUsersListFromDB = userService.getAllUsersListFromDB();
        model.addAttribute("usersDTOS", allUsersListFromDB);
        return "fetchedUsersData";
    }

    @GetMapping("/updatExistUser")
    public String updaterequest(@RequestParam Integer id, Model model) {

        UserDTO existingUserToUpdateData = userService.getExistingUserToUpdateData(id);

        if (existingUserToUpdateData != null) {
            model.addAttribute("byID", existingUserToUpdateData);
            return "fetchedUserforUpdate";
        }
        return "index";
    }
}
