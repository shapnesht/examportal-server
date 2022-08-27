package com.exam.services.Impl;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        List<Quiz> list = quizRepository.findAll();
        return new HashSet<>(list);
    }

    @Override
    public Quiz getQuizById(Long quizId) {
        return quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }

    @Override
    public Set<Quiz> getQuizzesByCategory(Long categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        return quizRepository.findQuizByCategory(category);
    }

    @Override
    public List<Quiz> getActiveQuizzes() {
        return quizRepository.findByIsActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizzesByCategory(Long categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        return quizRepository.findByCategoryAndIsActive(category, true);
    }
}
