package az.edu.ada.wm2.first_spring_boot_app.controller;

import az.edu.ada.wm2.first_spring_boot_app.bean.StudentBean;
import az.edu.ada.wm2.first_spring_boot_app.entity.Student;
import az.edu.ada.wm2.first_spring_boot_app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String getStudents(Model model) {

        model.addAttribute("school", "SITE");

        List<Student> students = studentService.getStudentList();

        model.addAttribute("students", students);

        return "student_list";
    }

    @GetMapping("/{id}")
    public String getStudent(Model model, @PathVariable Integer id){
        model.addAttribute("student", studentService.getById(id));

        return "student_info";
    }

    @GetMapping("/and/{firstName}/{lastName}")
    public String getStudentByNameAnd(Model model, @PathVariable
            String firstName, @PathVariable String lastName) {

        model.addAttribute("student", studentService.getStudentByNamesAnd(firstName, lastName));

        return "student_info";
    }

    @GetMapping("/or/{firstName}/{lastName}")
    public String getStudentByNameOr(Model model, @PathVariable
            String firstName, @PathVariable String lastName) {
        model.addAttribute("students", studentService.getStudentByNamesOr(firstName, lastName));

        return "student_list";
    }
}
