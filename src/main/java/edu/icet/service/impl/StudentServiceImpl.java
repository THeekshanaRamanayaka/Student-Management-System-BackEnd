package edu.icet.service.impl;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private ModelMapper mapper;

    @Bean
    public void setup() {
        this.mapper = new ModelMapper();
    }

    @Override
    public void addStudent(Student student) {
        StudentEntity entity = mapper.map(student, StudentEntity.class);
        System.out.println(entity);
        repository.save(entity);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        for (StudentEntity studentEntity : repository.findAll()) {
            studentList.add(mapper.map(studentEntity, Student.class));
        }
        return studentList;
    }

    @Override
    public Iterable<StudentEntity> getStudentByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    @Override
    public boolean updateStudent(Long id, Student student) {
        if (repository.findById(id).isPresent()) {
            StudentEntity entity = mapper.map(student, StudentEntity.class);
            repository.save(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteStudent(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student getStudentById(Long id) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        Iterator<StudentEntity> iterator = repository.findById(id).stream().iterator();
        if (repository.existsById(id)) {
            while (iterator.hasNext()) {
                studentArrayList.add(mapper.map(iterator.next(), Student.class));
            }
            return studentArrayList.get(0);
        } else {
            return null;
        }
    }
}
