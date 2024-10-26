package com.question.Controller;

import com.question.Model.Question;
import com.question.Service.Question_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:3000")
public class Question_Control {

    @Autowired
    public Question_Service service;

    @PostMapping
    public Question postQuestion(@RequestBody Question question){
        return service.postQuestion(question);
    }

    @GetMapping
    public List<Question> getAllQuestions(){
        return service.getAllQuestion();
    }

    @GetMapping("/{id}")
    public Optional<Question> getByID(@PathVariable Integer id){
        return service.getByID(id);
    }

    @PutMapping
    public Question updateQuestion(@RequestBody Question question){
        return service.postQuestion(question);
    }

    @GetMapping("/name")
    public String getName(){
        return "Jaison";
    }

    @GetMapping("/quizid/{id}")
    public Optional<List<Question>> getByQuizID(@PathVariable Integer id){
        return service.getQuestionsForQuiz(id);
    }
}
