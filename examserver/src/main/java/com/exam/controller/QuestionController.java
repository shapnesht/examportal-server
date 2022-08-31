package com.exam.controller;


import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.services.Impl.QuestionServiceImpl;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.addQuestion(question));
    }

    @PutMapping("/")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<?> getQuestion(@PathVariable("questionId") Long questionId) {
        return ResponseEntity.ok(questionService.getQuestionById(questionId));
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        Set<Question> set = quiz.getQuestions();
        List<Question> questionList = new ArrayList<>(set);
        Collections.shuffle(questionList);
        if (questionList.size() > quiz.getNumberOfQuestions()) {
            questionList = questionList.subList(0, (int) (quiz.getNumberOfQuestions() + 1 - 1));
        }
        questionList.forEach((question -> {
            question.setAnswer("");
        }));
        return ResponseEntity.ok(questionList);
    }

    @GetMapping("/quiz/all/{quizId}")
    public ResponseEntity<?> getAllQuestionsOfQuiz(@PathVariable("quizId") Long quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        Set<Question> set = quiz.getQuestions();
        return ResponseEntity.ok(set);
    }

    @DeleteMapping("/{questionId}")
    public void  deleteQuestion(@PathVariable("questionId") Long questionId) {
        questionService.deleteQuestionById(questionId);
    }

    @PostMapping("/evaluate-quiz")
    public ResponseEntity<?> evaluateQuiz(@RequestBody List<Question> questions) {
        double marks = 0;
        int attempted = 0;
        int correctAnswers= 0;

        double marksPerQuestion = quizService.getQuizById(questions.get(0).getQuiz().getQuizId()).getMaximumMarks() / (double) questions.size();

        for (Question q: questions) {
            Question qFromDb = questionService.getQuestionById(q.getQuestionId());
            if (qFromDb.getAnswer().equals(q.getGivenAnswer())) correctAnswers++;
            if (q.getGivenAnswer() != null) attempted++;
        }
        marks = marksPerQuestion * correctAnswers;
        return ResponseEntity.ok(Map.of("marks", marks, "attempted", attempted, "correctAnswers", correctAnswers));
    }
}
