package co.shu;

import co.shu.services.StudentService;
import java.util.List;
import co.shu.domain.Student;

public class App
{
    private static StudentService studentService;

    public static void main( String[] args )
    {
        studentService = new StudentService();

        List<Student> students = studentService.findAllStudents();
        for (Student student : students) {
            //System.out.println(student.getStudId(), student.getName(), student.getEmail(), student.getDob().toString());
            System.out.printf("%d, %s, %s, %s\n", student.getStudId(), student.getName(), student.getEmail(), student.getDob().toString());
        }
    }
}
