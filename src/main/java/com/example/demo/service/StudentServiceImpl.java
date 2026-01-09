package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // ✅ UPDATE STUDENT CODE (YOU ASKED)
    @Override
    public Student updateStudent(Long id, Student student) {
        Student existing = studentRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            return studentRepository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
