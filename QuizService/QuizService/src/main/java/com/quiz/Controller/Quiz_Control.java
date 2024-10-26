package com.quiz.Controller;

import com.quiz.Model.QuestionFromQuiz;
import com.quiz.Model.Quiz;
import com.quiz.Service.Quiz_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz")
public class Quiz_Control {
    @Autowired
    public Quiz_Service service;

    @Autowired
    public Question_Client newQuestionClient;

//    @GetMapping
//    public List<Quiz> getAllQuiz(){
//        return service.getAllQuiz();
//    }

    @PostMapping
    public Quiz setQuiz(@RequestBody Quiz quiz){
        return service.setQuiz(quiz);
    }



    @GetMapping("/{id}")
    public Quiz getQuizByID(@PathVariable Integer id){
        return service.getQuiz(id);
    }

    @GetMapping("/question")
    public List<QuestionFromQuiz> getAllQuestions() {
        return service.getAllQuestions();
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<List<QuestionFromQuiz>> getQuestionByID(@PathVariable Integer id){
        return service.getQuestionByID(id);
    }

}
