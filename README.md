# Fibonacci Generator

Fibonacci Generator es un proyecto Spring Boot que genera series de números de Fibonacci descendentes basadas en un tiempo de ejecución dado. Además, incluye funcionalidades para almacenar las series generadas en una base de datos y enviar notificaciones por correo electrónico.

## Características

- Generación de series de Fibonacci según el tiempo especificado.
- Almacenamiento de las series generadas en una base de datos MySQL.
- Envío de correos electrónicos con soporte para servidores SMTP (ej. Gmail).
- API documentada con Swagger.

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener lo siguiente instalado:

- **Java 17** o superior.
- **Maven**.
- **MySQL** (configura las variables de entorno para la conexión a la base de datos).

- Adicionalmente debes tener la base de datos creada con el nombre "fibonacci_db"
- Se debe configurar el application.properties con las credenciales de la base de datos
