package az.edu.ada.wm2.first_spring_boot_app.service;

import az.edu.ada.wm2.first_spring_boot_app.entity.Student;
import az.edu.ada.wm2.first_spring_boot_app.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentList() {
        List<Student> students = (List<Student>) studentRepository.findAll();

//        students.add(new StudentBean("Nuraddin", "Sadili"));
//        students.add(new StudentBean("Emil", "Huseynov"));
//        students.add(new StudentBean("Huseyn", "Jabbarov"));
//        students.add(new StudentBean("Kanan", "Gafarov"));
//        students.add(new StudentBean("Sabrina-Maria", "Sakka"));
//        students.add(new StudentBean("Ilaha", "Behbudova"));

        return students;
    }
}
