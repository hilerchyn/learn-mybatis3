package co.shu.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import co.shu.domain.Student;
import co.shu.util.MyBatisSqlSessionFactory;
import co.shu.mappers.StudentMapper;
import org.apache.ibatis.session.SqlSession;

public class StudentService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<Student> findAllStudents() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findAllStudents();
        }
        finally
        {
            sqlSession.close();
        }
    }

    public Student findStudentById(Integer studId) {
        logger.debug("select student by ID: {}", studId);

        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findStudentById(studId);
        }
        finally
        {
            sqlSession.close();
        }
    }

    public void createStudent(Student student) {

        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        }
        finally
        {
            sqlSession.close();
        }
    }
}
