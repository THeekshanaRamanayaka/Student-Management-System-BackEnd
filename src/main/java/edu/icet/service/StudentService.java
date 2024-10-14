package edu.icet.service;

import edu.icet.dto.Student;
import java.util.List;

public interface StudentService {
//    void addStudent(Student student);
//    List<Student> getAllStudent();
//    Iterable<StudentEntity> getStudentByFirstName(String firstName);
//    boolean updateStudent(Long id, Student student, MultipartFile file) throws IOException;
//    boolean deleteStudent(Long id);
//    Student getStudentById(Long id);
    void addStudent(Student student);
    Student searchStudentById(Integer id);
    void deleteStudentById(Integer id);
    void updateStudent(Student student);
    List<Student> findAllStudent();
}
