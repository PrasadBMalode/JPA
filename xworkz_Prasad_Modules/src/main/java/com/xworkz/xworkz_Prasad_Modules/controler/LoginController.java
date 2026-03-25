package com.xworkz.xworkz_Prasad_Modules.controler;

import com.xworkz.xworkz_Prasad_Modules.service.LoginService;
import com.xworkz.xworkz_Prasad_Modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
    public String loginPage(String email, String password, Model model, HttpSession httpSession) {

        String result = loginService.loginValidation(email, password);

        if (result.equalsIgnoreCase("LOGIN_SUCCESS")) {
            httpSession.setAttribute("loggedInEmail", email);
            model.addAttribute("email", email);
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
