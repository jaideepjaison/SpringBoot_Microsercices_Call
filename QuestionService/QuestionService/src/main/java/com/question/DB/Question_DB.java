package com.question.DB;

import com.question.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

public interface Question_DB extends JpaRepository<Question, Integer> {

    @Query("SELECT q FROM Question q WHERE q.quiz_id = :quizId")
    List<Question> findQuestionsByQuizId(@Param("quizId") int quizId);


}
