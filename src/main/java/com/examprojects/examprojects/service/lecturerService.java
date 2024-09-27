package com.examprojects.examprojects.service;
import com.examprojects.examprojects.model.lecturerModel;
import com.examprojects.examprojects.repository.lecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class lecturerService {

    @Autowired
    private lecturerRepository lecturerRepository;

    public lecturerModel getLecturerById(Long id) {
        return lecturerRepository.findById(id).orElse(null);
    }

    public lecturerModel saveLecturer(lecturerModel lecturer) {
        return lecturerRepository.save(lecturer);
    }
}
