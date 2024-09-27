package com.examprojects.examprojects.repository;
import com.examprojects.examprojects.model.gradeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface gradeRepository extends JpaRepository<gradeModel, Long> {
    List<gradeModel> findByTestId(Long testId);
}
