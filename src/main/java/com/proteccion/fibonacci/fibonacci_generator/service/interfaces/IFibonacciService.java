package com.proteccion.fibonacci.fibonacci_generator.service.interfaces;

import com.proteccion.fibonacci.fibonacci_generator.dtos.FibonacciRequestDTO;
import com.proteccion.fibonacci.fibonacci_generator.dtos.FibonacciResponseDTO;

import java.util.List;

public interface IFibonacciService {
    List<FibonacciResponseDTO> getAllFibonacciSeries();
    FibonacciResponseDTO generateFibonacciByTime(FibonacciRequestDTO executionTime);
}
