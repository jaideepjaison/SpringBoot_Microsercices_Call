package com.quiz.Controller;

import com.quiz.Model.QuestionFromQuiz;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(url = "http://localhost:8084/question" ,value = "question-client")
public interface Question_Client {

//    @GetMapping("/question/{id}")
//    List<QuestionFromQuiz> getQuestionOfQuiz(@PathVariable Integer id);

    @GetMapping()
    public List<QuestionFromQuiz> getName();
}
