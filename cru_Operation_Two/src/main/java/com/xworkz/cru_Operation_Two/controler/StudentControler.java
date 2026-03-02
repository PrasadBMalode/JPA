package com.xworkz.cru_Operation_Two.controler;

import com.xworkz.cru_Operation_Two.dto.StudentDTO;
import com.xworkz.cru_Operation_Two.service.StudentService;
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
public class StudentControler {

    @Autowired
    StudentService studentService;

    public StudentControler() {
        System.out.println("its controler..");
    }

    @PostMapping("/register")
    public String studentRegistration(StudentDTO studentDTO, Model model) {

        String validation = studentService.studentSaveValidation(studentDTO);
        if (validation.equalsIgnoreCase("Registration done, data saved to DB")) {
            model.addAttribute("registerDone", validation);
            return "index";
        } else if (validation.equalsIgnoreCase("Data not save d to DB")) {
            model.addAttribute("failedToDB", validation);
            return "index";
        } else if (validation.equalsIgnoreCase("student details already exist")) {
            model.addAttribute("detailsExist", validation);
            return "index";
        } else if (validation.equalsIgnoreCase("Registration failed, enter valid data")) {
            model.addAttribute("invalid", validation);
            return "index";
        }
        return "index";
    }

    @PostMapping("/fetchData")
    public String fetchStudentDetailsFromDB(Model model) {

        List<StudentDTO> studentDTOS = studentService.fetchingStudentDataValidation();

        model.addAttribute("studentDTOS", studentDTOS);
        return "fetchedStudentsData";

    }

    @GetMapping("/getDTO")
    public String updatingExistStudent(@RequestParam Integer id, Model model) {
        StudentDTO studentDTO = studentService.updateValidationByID(id);
        if (studentDTO != null) {
            model.addAttribute("studentDTO", studentDTO);
            return "forUpdate";
        }
        return "index";
    }
}
