package com.exam.services;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;

import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<?> getQuestions();
    public Question getQuestionById(Long questionId);
    public Set<Question> getAllQuestionsByQuiz(Quiz quiz);
    public void deleteQuestionById(Long questionId);
}
