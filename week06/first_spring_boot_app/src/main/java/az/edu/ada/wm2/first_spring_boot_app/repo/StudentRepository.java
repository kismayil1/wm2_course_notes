package az.edu.ada.wm2.first_spring_boot_app.repo;

import az.edu.ada.wm2.first_spring_boot_app.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
