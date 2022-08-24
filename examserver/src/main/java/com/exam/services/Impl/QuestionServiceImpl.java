package com.exam.services.Impl;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.repository.QuestionRepository;
import com.exam.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    public QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<?> getQuestions() {
        List<Question> list = questionRepository.findAll();
        return new HashSet<>(list);
    }

    @Override
    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getAllQuestionsByQuiz(Quiz quiz) {
        return questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestionById(Long questionId) {
        Question question = new Question();
        question.setQuestionId(questionId);
        questionRepository.delete(question);
    }
}
