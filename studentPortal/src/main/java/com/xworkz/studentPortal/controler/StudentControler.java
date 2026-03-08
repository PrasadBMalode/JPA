package com.xworkz.studentPortal.controler;

import com.xworkz.studentPortal.dto.StudentDTO;
import com.xworkz.studentPortal.service.StudentService;
import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/")
public class StudentControler {

    @Autowired
    StudentService studentService;

    public StudentControler() {
        System.out.println("its a controler class");
    }

    @PostMapping("/register")
    public String studentRegister(StudentDTO studentDTO, Model model) {
        String message = studentService.saveData(studentDTO);
        if(message.equalsIgnoreCase("Registered successfully")) {
            model.addAttribute("success",message);
            return "index";
        }else if (message.equalsIgnoreCase("Not Registered")){
            model.addAttribute("errmsg",message);
            return "index";
        }else{
            model.addAttribute("errmsg",message);
            return "index";
        }
    }


    @GetMapping("readAllData")
    public String getData(Model model){
        List<StudentDTO> dtos = studentService.getDtos();
        model.addAttribute("list", dtos);
        System.out.println("read data=="+dtos);
        return "showTrainee";
    }

    @GetMapping("getData")
    public String getTrainee(@RequestParam String email,Model model){
        System.out.println("id========"+email);
        StudentDTO studentDTO = studentService.getTraineeInServiceBasedOnEmail(email);
        if (studentDTO!=null){
            model.addAttribute("dto",studentDTO);
            return "getTrainee";
        }
        return "index";
    }

    @PostMapping("update")
    public String updateData(StudentDTO studentDTO,Model model){
        studentService.updateData(studentDTO);
        List<StudentDTO> dtos = studentService.getDtos();
        model.addAttribute("list",dtos);
        return "showTrainee";
    }

    @GetMapping("deleteData")
    public String deleteData(@RequestParam String email,Model model){
//delete
        studentService.deleteData(email);
        List<StudentDTO> dtos = studentService.getDtos();
        model.addAttribute("list",dtos);
        return "showTrainee";
    }

}
