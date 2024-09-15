package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> getAllStudent();
    Iterable<StudentEntity> getStudentByFirstName(String firstName);
    boolean updateStudent(Long id, Student student);
    boolean deleteStudent(Long id);
    Student getStudentById(Long id);
}
