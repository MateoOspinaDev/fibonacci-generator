package com.proteccion.fibonacci.fibonacci_generator.service.interfaces;

public interface IMailService {
    Boolean sendMail(String to, String subject, String text);
}
