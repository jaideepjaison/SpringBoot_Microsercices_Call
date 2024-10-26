package com.quiz.DB;

import com.quiz.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Quiz_DB extends JpaRepository<Quiz,Integer> {
}
