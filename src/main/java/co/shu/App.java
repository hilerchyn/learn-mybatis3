package co.shu;

import co.shu.services.StudentService;
import java.util.List;
import co.shu.domain.Student;

public class App
{
    private static StudentService studentService;

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        studentService = new StudentService();

        List<Student> students = studentService.findAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
