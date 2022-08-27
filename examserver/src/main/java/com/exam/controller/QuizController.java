package com.exam.controller;

import com.exam.model.exam.Quiz;
import com.exam.services.Impl.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizServiceImpl quizService;

    @PostMapping("/")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizService.addQuiz(quiz));
    }

    @PutMapping("/")
    public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizService.updateQuiz(quiz));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllActiveQuizzes() {
        return ResponseEntity.ok(quizService.getQuizzes());
    }

    @GetMapping("/active/")
    public ResponseEntity<?> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getActiveQuizzes());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getQuizByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(quizService.getQuizzesByCategory(categoryId));
    }

    @GetMapping("/active/category/{categoryId}")
    public ResponseEntity<?> getActiveQuizByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(quizService.getActiveQuizzesByCategory(categoryId));
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuiz(@PathVariable("quizId") Long quizId) {
        return ResponseEntity.ok(quizService.getQuizById(quizId));
    }

    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId) {
        quizService.deleteQuiz(quizId);
    }
}
