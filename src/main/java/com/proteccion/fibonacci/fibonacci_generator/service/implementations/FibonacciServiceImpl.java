package com.proteccion.fibonacci.fibonacci_generator.service.implementations;

import com.proteccion.fibonacci.fibonacci_generator.FibonacciRepository.FibonacciRepository;
import com.proteccion.fibonacci.fibonacci_generator.Utils.TimeUtils;
import com.proteccion.fibonacci.fibonacci_generator.dtos.FibonacciRequestDTO;
import com.proteccion.fibonacci.fibonacci_generator.dtos.FibonacciResponseDTO;
import com.proteccion.fibonacci.fibonacci_generator.model.FibonacciResult;
import com.proteccion.fibonacci.fibonacci_generator.service.interfaces.IFibonacciService;
import com.proteccion.fibonacci.fibonacci_generator.service.interfaces.IMailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FibonacciServiceImpl implements IFibonacciService {

    private final FibonacciRepository repository;
    private final ModelMapper modelMapper;
    private final IMailService mailService;

    @Autowired
    public FibonacciServiceImpl(FibonacciRepository repository, ModelMapper modelMapper, IMailService mailService) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.mailService = mailService;
    }

    public FibonacciResponseDTO generateFibonacciByTime(FibonacciRequestDTO requestDto) {

        if (requestDto == null) {
            throw new IllegalArgumentException("La solicitud no puede estar vacía.");
        }

        if (requestDto.getExecutionTime() == null || requestDto.getExecutionTime().isEmpty()) {
            throw new IllegalArgumentException("El tiempo de ejecución no puede ser nulo o vacío.");
        }

        String executionTime = requestDto.getExecutionTime();

        TimeUtils.validateTimeFormat(executionTime);

        // Separar horas, minutos y segundos
        String[] timeParts = executionTime.split(":");
        int minutes = Integer.parseInt(timeParts[1]); // Minutos: semilla inicial
        int seconds = Integer.parseInt(timeParts[2]); // Segundos: cantidad de números a generar

        // Generar la serie
        List<Long> series = generateFibonacciDescending(minutes, seconds);

        FibonacciResult result = new FibonacciResult(requestDto.getExecutionTime(), series.toString());

        repository.save(result);

        // Enviar correo
        enviarCorreo(String.valueOf(minutes), String.valueOf(seconds), series);

        return  modelMapper.map(result, FibonacciResponseDTO.class);
    }

    private List<Long> generateFibonacciDescending(int seedMinutes, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("La cantidad de números (segundos) debe ser mayor a 0.");
        }

        // Obtener las dos semillas
        int firstSeed = seedMinutes / 10; // Decenas de los minutos
        int secondSeed = seedMinutes % 10; // Unidades de los minutos

        // Asegurar que el primer número sea el menor
        int minSeed = Math.min(firstSeed, secondSeed);
        int maxSeed = Math.max(firstSeed, secondSeed);

        // Inicializar la serie con las semillas
        List<Long> series = new ArrayList<>();
        series.add((long) minSeed);
        series.add((long) maxSeed);

        // Generar la serie sumando los dos últimos números
        long a = minSeed, b = maxSeed;
        for (int i = 2; i < count + 2; i++) {
            long next = a + b;
            series.add(0, next);
            a = b;
            b = next;
        }

        series.sort(Comparator.reverseOrder());

        return series;
    }

    private void enviarCorreo(String minutos, String segundos, List<Long> series) {
        String message = "Se ha generado una nueva serie Fibonacci con semilla " + minutos + " y " + segundos + " números."
                + "El resultado es: " + series;

        // Enviar correo
        mailService.sendMail("mateoospinadesarrollo@gmail.com",
                "Prueba técnica - Mateo Ospina Agudelo",
                message);
    }
    @Override
    public List<FibonacciResponseDTO> getAllFibonacciSeries() {
        List<FibonacciResult> results = repository.findAll();

        return results.stream()
                .map(result -> modelMapper.map(result, FibonacciResponseDTO.class))
                .collect(Collectors.toList());
    }

}