package com.exam.services;

import com.exam.model.exam.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService{
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<?> getQuizzes();
    public Quiz getQuizById(Long quizId);
    void deleteQuiz(Long quizId);
    public Set<Quiz> getQuizzesByCategory(Long categoryId);
    public List<Quiz> getActiveQuizzes();
    public List<Quiz> getActiveQuizzesByCategory(Long categoryId);
}
