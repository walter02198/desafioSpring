# DesafioSpring

Aplicación de consola en Spring Boot que consume la API de Gutendex para buscar y mostrar información de libros, incluyendo los 10 más descargados y estadísticas de descargas.

## 🛠️ Tecnologías

- Java 17
- Spring Boot 3.2.5
- Maven
- Jackson Databind 2.17.0 (para procesamiento JSON)
- HttpClient (Java 11+ para llamadas HTTP)

## 📋 Requisitos

- Java 17 o superior
- Maven 3.6+

## 🚀 Cómo ejecutar

```bash
# Clonar el repositorio
git clone [url]
cd desafioSpring

# Ejecutar
mvn spring-boot:run
```

## 📁 Estructura del proyecto

```
src/main/java/com/aluracursos/desafioSpring/
├── model/              # DTOs y records (Datos, DatosLibros, DatosAutor)
├── service/            # ConsumoApi, ConvierteDatos, IConvierteDatos
├── principal/          # Principal (menú de consola)
└── DesafioSpringApplication.java
```

## 🎯 Características

- Top 10 libros más descargados
- Búsqueda de libros por nombre
- Estadísticas de descargas (promedio, máximo, mínimo)

## Autor

Walter Valverde
