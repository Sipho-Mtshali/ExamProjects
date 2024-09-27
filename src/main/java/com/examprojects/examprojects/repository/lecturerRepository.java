package com.examprojects.examprojects.repository;
import com.examprojects.examprojects.model.lecturerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface lecturerRepository extends JpaRepository<lecturerModel, Long> {
}

