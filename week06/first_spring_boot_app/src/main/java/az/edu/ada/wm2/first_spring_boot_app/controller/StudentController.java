package az.edu.ada.wm2.first_spring_boot_app.controller;

import az.edu.ada.wm2.first_spring_boot_app.bean.StudentBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/list")
    public String getStudents(Model model) {

        model.addAttribute("school", "SITE");

//        List<StudentBean> students = new StudentService().getList();
//
//        model.addAttribute("students", students);

        return "student_list";
    }
}
