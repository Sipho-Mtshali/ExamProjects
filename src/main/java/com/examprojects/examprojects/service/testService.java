package com.examprojects.examprojects.service;

import com.examprojects.examprojects.model.testModel;
import com.examprojects.examprojects.repository.testRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class testService {

    @Autowired
    private testRepository testRepository;

    private static final Logger logger = LoggerFactory.getLogger(testService.class);

    public List<testModel> getTestsByLecturerId(Long lecturerId)
    {
        return testRepository.findByLecturerId(lecturerId);
    }

    public testModel createTest(testModel test)
    {
        logger.info("Creating test: {}", test); // Log the test being created
        return testRepository.save(test);
    }

    public testModel getTestById(Long id)
    {
        return testRepository.findById(id).orElse(null);
    }

    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }
}
