package com.proteccion.fibonacci.fibonacci_generator.FibonacciRepository;

import com.proteccion.fibonacci.fibonacci_generator.model.FibonacciResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FibonacciRepository extends JpaRepository<FibonacciResult, Long> {}
