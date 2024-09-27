package com.examprojects.examprojects.service;
import com.examprojects.examprojects.model.gradeModel;
import com.examprojects.examprojects.repository.gradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class gradeService {

    @Autowired
    private gradeRepository gradeRepository;

    public List<gradeModel> getGradesByTestId(Long testId) {
        return gradeRepository.findByTestId(testId);
    }

    public gradeModel saveGrade(gradeModel grade) {
        return gradeRepository.save(grade);
    }
}


