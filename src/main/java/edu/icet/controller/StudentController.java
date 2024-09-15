package edu.icet.controller;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void setStudent(@ModelAttribute Student student) {
        System.out.println(student);
        studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@ModelAttribute Student student, @PathVariable Long id) {
        return studentService.updateStudent(id, student)?
                ResponseEntity.ok("Student updated successfully"):
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id)?
                ResponseEntity.ok("Student delete successfully"):
                ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{firstName}")
    public Iterable<StudentEntity> getStudentByFirstName(@PathVariable String firstName) {
        return studentService.getStudentByFirstName(firstName);
    }

    @GetMapping("/student-id/{id}")
    public Student getStudentByFirstName(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}
