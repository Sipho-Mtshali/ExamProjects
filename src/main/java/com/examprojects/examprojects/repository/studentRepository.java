package com.examprojects.examprojects.repository;
import com.examprojects.examprojects.model.studentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<studentModel, Long> {
}

