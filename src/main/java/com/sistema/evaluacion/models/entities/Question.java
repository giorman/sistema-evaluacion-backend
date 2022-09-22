package com.sistema.evaluacion.models.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 5000)
    private String content;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @Transient
    private String responseUser;

    private String responseCorrect;

    @ManyToOne(fetch = FetchType.EAGER)
    private Evaluation evaluation;
}
