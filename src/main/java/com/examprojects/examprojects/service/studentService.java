package com.examprojects.examprojects.service;
import com.examprojects.examprojects.model.studentModel;
import com.examprojects.examprojects.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class studentService {

    @Autowired
    private studentRepository studentRepository;

    public studentModel getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public studentModel saveStudent(studentModel student) {
        return studentRepository.save(student);
    }
}

