package az.edu.ada.wm2.first_spring_boot_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/student")

public class StudentController {
    @GetMapping("/list")
    public String getStudents(Model model){
        model.addAttribute("school", "SITE");

        model.addAttribute("school", new ArrayList<>());
        return "student_list";
    }

}
