# Tarea 3 DWES: Técnicas de Acceso a Datos con JPA e Hibernate

Este proyecto consiste en la implementación de una aplicación Java para la gestión de información de un vivero. Se utiliza la tecnología **JPA** junto con el motor **Hibernate**, bajo el framework **Spring**, siguiendo los requisitos establecidos en la asignatura **Programación Web en Entorno Servidor** del curso **2º DAW (2024/2025)**.

## Descripción

La aplicación amplía el proyecto de la tarea anterior (Tarea 2) incorporando un mecanismo de persistencia de datos basado en JPA. Se estructura en una arquitectura por capas, respetando las relaciones entre las entidades y las funcionalidades definidas en el diagrama de casos de uso.

### Funcionalidades principales
- Gestión de usuarios (registro, autenticación y control de sesiones).
- Operaciones CRUD sobre entidades relacionadas con plantas y ejemplares.
- Gestión de mensajes de seguimiento para ejemplares del vivero.
- Búsqueda y filtrado de datos.

### Tecnologías y herramientas utilizadas
- **Java Spring**: Framework principal.
- **JPA & Hibernate**: Persistencia de datos.
- **Maven**: Gestión de dependencias.
- **Base de datos relacional**: Configuración desde un fichero `application.properties`.
- **GitHub**: Control de versiones y entrega del proyecto.

## Requisitos del sistema
1. **Entidades y relaciones**: Basadas en el modelo de datos del proyecto original, anotadas con metadatos para mapeo en la base de datos.
2. **Capa de presentación**: Interacción clara y validada con el usuario mediante menús y mensajes.
3. **Capa de negocio**: Implementada con clases anotadas como `@Service`.
4. **Capa de acceso a datos**: Clases anotadas con `@Repository` para la interacción directa con la base de datos.
5. **Base de datos inicial**: Se incluye un fichero `.sql` para crear y poblar la base de datos.
