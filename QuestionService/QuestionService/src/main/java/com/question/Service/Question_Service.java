package com.question.Service;

import com.question.DB.Question_DB;
import com.question.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Question_Service {

    @Autowired
    public Question_DB questionDb;

    public Question postQuestion(Question question){
        return questionDb.save(question);
    }

    public List<Question> getAllQuestion(){
        return questionDb.findAll();
    }

    public Optional<Question> getByID(Integer id){
        return questionDb.findById(id);
    }
    public Question updateQuestion(Question question){
        return questionDb.save(question);
    }

    public Optional<List<Question>> getQuestionsForQuiz(int quizId) {
        List<Question> questions = questionDb.findQuestionsByQuizId(quizId);
        return Optional.ofNullable(questions);
    }



}
