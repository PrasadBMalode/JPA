package com.xworkz.xworkz_Prasad_Modules.controler;

import com.xworkz.xworkz_Prasad_Modules.dto.UserDTO;
import com.xworkz.xworkz_Prasad_Modules.service.ViewService;
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
public class ViewController {

    @Autowired
    ViewService viewService;

    public ViewController(){
        System.out.println("View controller...");
    }

    @PostMapping("/home")
    public String home(){
        return "loginSuccess";
    }

    @GetMapping("/dashboardLeftHome")
    public String dashboardLeftHome(){
        return "loginSuccess";
    }

    @PostMapping("/loginfromProfile")
    public String loginfromProfile(){
        return "index";
    }
    @PostMapping("/logout")
    public String logout(){
        return "index";
    }

    @GetMapping("/profileFromDashboard")
    public String profileFromDashboard(){
        return "profile";
    }

    @GetMapping("/profileUpdate")
    public String viewProfile(@RequestParam String email, Model model){
        UserDTO userDTO = viewService.readUsearToUpdateData(email);
        model.addAttribute("dto",userDTO);
        return "profile";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(Model model){
        List<UserDTO> userDTOS = viewService.readAllUsersList();
        model.addAttribute("usersList",userDTOS);
        return "dashboard";
    }

    @PostMapping("/updateProfile")
    public String updatingUserData(UserDTO userDTO,Model model){

        boolean updated = viewService.updateExistUserData(userDTO);
        if (updated){
            model.addAttribute("updateSuccess","Your Data Successfully Updated ");
            return "profile";
        }else {
            model.addAttribute("updateFailed","Your Data has been not updated");
            return "profile";
        }
    }


}
