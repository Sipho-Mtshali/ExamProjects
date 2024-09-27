package com.examprojects.examprojects.repository;
import com.examprojects.examprojects.model.testModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface testRepository extends JpaRepository<testModel, Long> {
    List<testModel> findByLecturerId(Long lecturerId);
}

