package edu.icet.controller;

import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    final StudentService studentService;

    @PostMapping("/addStudent")
    public void addStudent(@RequestPart("student") Student student, @RequestPart("image") MultipartFile file) throws IOException {
        System.out.println(student);
        try {
            student.setImage(file.getBytes());
            studentService.addStudent(student);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    @GetMapping("/searchByID/{id}")
    public Student searchStudent(@PathVariable Integer id) {
        return studentService.searchStudentById(id);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
    }

    @PatchMapping("/updateStudent")
    public void updateStudent(@RequestPart("student") Student student, @RequestPart("image") MultipartFile file) throws IOException {
        student.setImage(file.getBytes());
        studentService.updateStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.findAllStudent();
    }
}
