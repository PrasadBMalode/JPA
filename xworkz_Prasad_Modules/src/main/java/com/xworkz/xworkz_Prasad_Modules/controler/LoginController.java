package com.xworkz.xworkz_Prasad_Modules.controler;

import com.xworkz.xworkz_Prasad_Modules.dto.LoginDTO;
import com.xworkz.xworkz_Prasad_Modules.service.LoginService;
import com.xworkz.xworkz_Prasad_Modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    public LoginController() {
        System.out.println("Login Controller...");
    }
    @PostMapping("/loginButton")
    public String loginButton() {
        return "index";
    }
    @GetMapping("/forgotPassword")
    public String forgotPassword(){
        return "forgotPassword";
    }

    @PostMapping("/loginPage")
    public String loginPage(@Valid LoginDTO loginDTO, BindingResult bindingResult, Model model, HttpSession httpSession) {

        if (bindingResult.hasErrors()){

            if (bindingResult.hasFieldErrors("email")) {
                model.addAttribute("emailError", bindingResult.getFieldError("email").getDefaultMessage());
            } else {
                model.addAttribute("emailError", "");
            }

            if (bindingResult.hasFieldErrors("password")) {
                model.addAttribute("passwordError", bindingResult.getFieldError("password").getDefaultMessage());
            } else {
                model.addAttribute("passwordError", "");
            }
            return "index";
        }

        String result = loginService.loginValidation(loginDTO.getEmail(), loginDTO.getPassword());

        if (result.equalsIgnoreCase("LOGIN_SUCCESS")) {
            httpSession.setAttribute("loggedInEmail", loginDTO.getEmail());
            model.addAttribute("email", loginDTO.getEmail());
            return "loginSuccess";

        } else if (result.equalsIgnoreCase("EMAIL_NOT_FOUND")) {
            model.addAttribute("loginFailed", "Email not found");
            return "index";

        } else if (result.equalsIgnoreCase("INVALID_PASSWORD")) {
            model.addAttribute("loginFailed", "Invalid password");
            return "index";

        } else if (result.equalsIgnoreCase("ACCOUNT_BLOCKED")) {
            model.addAttribute("loginFailed", "Account is blocked after 3 failed attempts");
            return "index";
        }
        model.addAttribute("loginFailed", "Something went wrong");
        return "index";
    }
}
