package com.quiz.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quiz_id;

    private String quiz_type;

    transient private ResponseEntity<List<QuestionFromQuiz>> questions;
}
