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

        // ================= EXISTING VALIDATION =================
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

            model.addAttribute("userDTO", userDTO);
            return "register";
        }



        // Confirm password validation
        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            model.addAttribute("confirmPasswordError", "Passwords do not match");
            model.addAttribute("userDTO", userDTO);
            return "register";
        }

        // File validation
        if (userDTO.getFile() == null || userDTO.getFile().isEmpty()) {
            model.addAttribute("fileError", "Please upload a file");
            model.addAttribute("userDTO", userDTO);
            return "register";
        }

        String contentType = userDTO.getFile().getContentType();

        if (!(contentType.equals("image/jpeg") ||
                contentType.equals("image/png") ||
                contentType.equals("application/pdf"))) {

            model.addAttribute("fileError", "Only JPG, PNG, PDF allowed");
            model.addAttribute("userDTO", userDTO);
            return "register";
        }

        if (userDTO.getFile().getSize() > 2 * 1024 * 1024) {
            model.addAttribute("fileError", "File must be less than 2MB");
            model.addAttribute("userDTO", userDTO);
            return "register";
        }


        String validation = userService.registrationValidation(userDTO);

        if (validation.equalsIgnoreCase("Registration Done")) {
            model.addAttribute("registerSuccess", validation);
        } else if (validation.equalsIgnoreCase("Registration Failed...!")) {
            model.addAttribute("registerFailed", validation);
        } else if (validation.equalsIgnoreCase("User already exist")) {
            model.addAttribute("existData", validation);
        }

        return "register";
    }

//    @PostMapping("/emailCheck")
//    public String emailVerification(String email ) {
//        UserDTO user = userService.checkingExistUserByEmail(email);
//        if (user!=null){
//            return "resetPassword";
//        }else {
//            return "forgotPassword";
//        }
//    }

    @PostMapping("/emailCheck")
    public String emailVerification(String email, Model model) {

        UserDTO user = userService.checkingExistUserByEmail(email);

        if (user != null) {
            model.addAttribute("email", email); // ✅ pass email
            return "resetPassword";
        } else {
            model.addAttribute("error", "Email not found");
            return "forgotPassword";
        }
    }

//    @PostMapping("/updatePassword")
//    public String updatePassword(UserDTO userDTO, Model model){
//        boolean updatingPassword = userService.updatingPassword(userDTO);
//        if (updatingPassword){
//            model.addAttribute("updatedSuccessfully","Your password updated you can login now");
//            return "resetPassword";
//        }
//        model.addAttribute("updateFail","Please check the password...!");
//        return "resetPassword";
//    }

    @PostMapping("/updatePassword")
    public String updatePassword(UserDTO userDTO, Model model) {

        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            model.addAttribute("updateFail", "Passwords do not match");
            model.addAttribute("email", userDTO.getEmail());
            return "resetPassword";
        }

        boolean updatingPassword = userService.updatingPassword(userDTO);

        if (updatingPassword) {
            model.addAttribute("updatedSuccessfully", "Your password updated, you can login now");
            return "index";
        }

        model.addAttribute("updateFail", "Please check the password...!");
        return "resetPassword";
    }

}
