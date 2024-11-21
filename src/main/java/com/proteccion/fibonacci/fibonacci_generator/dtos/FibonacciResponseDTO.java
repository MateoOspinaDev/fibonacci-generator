package com.proteccion.fibonacci.fibonacci_generator.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FibonacciResponseDTO {
    private String series;
    private String generatedAt;
}
