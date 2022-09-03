package com.exam.repository;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Set<Quiz> findQuizByCategory(Category category);
    List<Quiz> findByIsActive(boolean active);
    List<Quiz> findByCategoryAndIsActive(Category category, boolean active);
}
