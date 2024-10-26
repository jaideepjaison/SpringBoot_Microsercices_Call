package com.quiz.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionFromQuiz {

    private int question_id;

    private String question;

    private int quiz_id;


}
