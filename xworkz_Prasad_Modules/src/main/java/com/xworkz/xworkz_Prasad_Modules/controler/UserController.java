package com.xworkz.xworkz_Prasad_Modules.controler;

import com.xworkz.xworkz_Prasad_Modules.dto.UserDTO;
import com.xworkz.xworkz_Prasad_Modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    public UserController() {
        System.out.println("User Controller...");
    }

    @GetMapping("/registerFirst")
    public String mapedRegistration() {
        return "register";
    }

    @PostMapping("/register")
    public String registration(@Valid UserDTO userDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            if (bindingResult.hasFieldErrors("name")) {
                model.addAttribute("nameError", bindingResult.getFieldError("name").getDefaultMessage());
            } else {
                model.addAttribute("nameError", "");
            }

            if (bindingResult.hasFieldErrors("dob")) {
                String code = bindingResult.getFieldError("dob").getCode();
                if ("typeMismatch".equals(code)) {
                    model.addAttribute("dobError", "Invalid date format");
                } else {
                    model.addAttribute("dobError", bindingResult.getFieldError("dob").getDefaultMessage());
                }
            } else {
                model.addAttribute("dobError", "");
            }

            if (bindingResult.hasFieldErrors("age")) {
                model.addAttribute("ageError", bindingResult.getFieldError("age").getDefaultMessage());
            } else {
                model.addAttribute("ageError", "");
            }

            if (bindingResult.hasFieldErrors("gender")) {
                model.addAttribute("genderError", bindingResult.getFieldError("gender").getDefaultMessage());
            } else {
                model.addAttribute("genderError", "");
            }

            if (bindingResult.hasFieldErrors("location")) {
                model.addAttribute("locationError", bindingResult.getFieldError("location").getDefaultMessage());
            } else {
                model.addAttribute("locationError", "");
            }

            if (bindingResult.hasFieldErrors("email")) {
                model.addAttribute("emailError", bindingResult.getFieldError("email").getDefaultMessage());
            } else {
                model.addAttribute("emailError", "");
            }

            if (bindingResult.hasFieldErrors("phNumber")) {
                model.addAttribute("phoneError", bindingResult.getFieldError("phNumber").getDefaultMessage());
            } else {
                model.addAttribute("phoneError", "");
            }

            if (bindingResult.hasFieldErrors("password")) {
                model.addAttribute("passwordError", bindingResult.getFieldError("password").getDefaultMessage());
            } else {
                model.addAttribute("passwordError", "");
            }

            if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
                model.addAttribute("confirmPasswordError", "Passwords do not match");
                model.addAttribute("userDTO", userDTO);
                return "register";
            }

            model.addAttribute("userDTO", userDTO);
            return "register";
        }
        String validation = userService.registrationValidation(userDTO);
        if (validation.equalsIgnoreCase("Registration Done")) {
            model.addAttribute("registerSuccess", validation);
            return "register";
        } else if (validation.equalsIgnoreCase("Registration Failed...!")) {
            model.addAttribute("registerFailed", validation);
            return "register";
        } else if (validation.equalsIgnoreCase("User already exist")) {
            model.addAttribute("existData", validation);
            return "register";
        }
        return "register";
    }

}
