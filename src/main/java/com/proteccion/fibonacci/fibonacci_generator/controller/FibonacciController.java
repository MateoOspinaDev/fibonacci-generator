package com.proteccion.fibonacci.fibonacci_generator.controller;

import com.proteccion.fibonacci.fibonacci_generator.dtos.FibonacciRequestDTO;
import com.proteccion.fibonacci.fibonacci_generator.dtos.FibonacciResponseDTO;
import com.proteccion.fibonacci.fibonacci_generator.service.interfaces.IFibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    private final IFibonacciService fibonacciService;

    @Autowired
    public FibonacciController(IFibonacciService fibonacciServiceImpl) {
        this.fibonacciService = fibonacciServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<FibonacciResponseDTO>> getAllFibonacciSeries() {
        return ResponseEntity.ok(fibonacciService.getAllFibonacciSeries());
    }

    @PostMapping("/generate-by-time")
    public ResponseEntity<FibonacciResponseDTO> generateByExecutionTime(@RequestBody FibonacciRequestDTO request) {
        FibonacciResponseDTO result = fibonacciService.generateFibonacciByTime(request);
        return ResponseEntity.ok(result);
    }

}
