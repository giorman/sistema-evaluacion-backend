package com.sistema.evaluacion.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResultDto {
    Double pointMax;
    Integer intent;
    Integer numberCorrect;
}
