package com.proteccion.fibonacci.fibonacci_generator.Utils;

public class TimeUtils {

    // Método para validar que la hora está en formato correcto (HH:MM:SS)
    public static void validateTimeFormat(String time) {
        if (!time.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
            throw new IllegalArgumentException("La hora debe estar en formato 'HH:MM:SS', donde HH, MM y SS son números de dos dígitos.");
        }

        // Separar hora, minutos y segundos
        String[] timeParts = time.split(":");

        // Validar la hora, minutos y segundos
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int seconds = Integer.parseInt(timeParts[2]);

        // Validación de la hora (debe estar entre 00 y 23)
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("La hora debe estar entre 00 y 23.");
        }

        // Validación de los minutos (deben estar entre 00 y 59)
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Los minutos deben estar entre 00 y 59.");
        }

        // Validación de los segundos (deben estar entre 00 y 59)
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Los segundos deben estar entre 00 y 59.");
        }
    }

    // Método para separar los minutos y segundos del tiempo "HH:MM:SS"
    public static int[] getTimeParts(String time) {
        String[] timeParts = time.split(":");
        return new int[] { Integer.parseInt(timeParts[1]), Integer.parseInt(timeParts[2]) };  // Minutos y segundos
    }
}

