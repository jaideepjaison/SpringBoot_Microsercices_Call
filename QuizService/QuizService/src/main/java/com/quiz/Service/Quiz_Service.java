package com.quiz.Service;

import com.quiz.Controller.Question_Client;
import com.quiz.DB.Quiz_DB;
import com.quiz.Model.QuestionFromQuiz;
import com.quiz.Model.Quiz;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Quiz_Service {
    @Autowired
    public Quiz_DB quiz_db;
    @Autowired
    public Question_Client questionClient;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private RestTemplate restTemplate;

    public Quiz setQuiz(Quiz quiz){
        return (Quiz) quiz_db.save(quiz);
    }

    public Quiz getQuiz(Integer id){

        Quiz quizDetails = quiz_db.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found for id: " + id));
        ResponseEntity<List<QuestionFromQuiz>> questions=getQuestionByID(1);

        quizDetails.setQuestions(questions);

        return quizDetails;
    }



    public List<QuestionFromQuiz> getAllQuestions() {
        String url = "http://localhost:8084/question";

        // Call the Question API to get a list of questions
        ResponseEntity<QuestionFromQuiz[]> response = restTemplate.getForEntity(url, QuestionFromQuiz[].class);

        // Convert the array to a list and return
        return Arrays.asList(response.getBody());
    }

    public ResponseEntity<List<QuestionFromQuiz>> getQuestionByID(int questionId) {
        String url = "http://localhost:8084/question/"+ questionId;;

        // Call the Question API to get a list of questions
        ResponseEntity<List<QuestionFromQuiz>> response = restTemplate.exchange(url, HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<QuestionFromQuiz>>() {});
        // Convert the array to a list and return
        return response;
    }






}
