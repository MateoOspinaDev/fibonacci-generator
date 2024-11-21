package com.proteccion.fibonacci.fibonacci_generator.model;

import jakarta.persistence.*;

@Entity
public class FibonacciResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "generated_at")
    private String generatedAt;

    @Column(name = "series", columnDefinition = "LONGTEXT")
    private String series;

    public FibonacciResult(String generatedAt, String series) {
        this.generatedAt = generatedAt;
        this.series = series;
    }

    public FibonacciResult() {
    }

    public String getGeneratedAt() {
        return generatedAt;
    }

    public String getSeries() {
        return series;
    }
}