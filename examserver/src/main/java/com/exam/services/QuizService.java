package com.exam.services;

import com.exam.model.exam.Quiz;

import java.util.Set;

public interface QuizService{
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<?> getQuizzes();
    public Quiz getQuizById(Long quizId);
    void deleteQuiz(Long quizId);
}
