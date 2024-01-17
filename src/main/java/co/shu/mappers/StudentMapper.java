package co.shu.mappers;

import java.util.List;
import co.shu.domain.Student;

public interface StudentMapper {
    List<Student> findAllStudents();
    Student findStudentById(Integer id);
    void insertStudent(Student student);
}
