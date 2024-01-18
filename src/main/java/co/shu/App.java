package co.shu;

import co.shu.services.StudentService;
import java.util.List;
import co.shu.domain.Student;
import java.time.Instant;
import java.util.Date;

public class App
{
    private static StudentService studentService;

    public static void main( String[] args )
    {
        studentService = new StudentService();

        // get student list
        List<Student> students = studentService.findAllStudents();
        for (Student student : students) {
            //System.out.println(student.getStudId(), student.getName(), student.getEmail(), student.getDob().toString());
            System.out.printf("%d, %s, %s, %s\n", student.getStudId(), student.getName(), student.getEmail(), student.getDob().toString());
        }

        // get one student
        Student student = studentService.findStudentById(2);
        System.out.printf("%d, %s, %s, %s\n", student.getStudId(), student.getName(), student.getEmail(), student.getDob().toString());

        // create student
        student = new Student();
        Long id = Instant.now().getEpochSecond();
        String idStr = String.format("%d", Instant.now().getEpochSecond());
        student.setStudId(id.intValue());
        student.setName("student_" + idStr);
        student.setEmail("student_" + idStr + "@gmail.com");
        student.setDob(new Date());
        studentService.createStudent(student);

        // fetch the created student
        student = studentService.findStudentById(id.intValue());
        System.out.printf("created student: %d, %s, %s, %s\n", student.getStudId(), student.getName(), student.getEmail(), student.getDob().toString());
    }
}
