# PLAN DE IMPLEMENTACIÓN — KAIROS MVP

## Periodo

**Inicio:** 29 de agosto de 2026  
**Fecha objetivo:** finales de septiembre / inicios de octubre de 2026

El objetivo es desarrollar una versión funcional del MVP de Kairos que permita utilizar la disponibilidad de los docentes, los cursos, las horas de dictado, los bloques horarios y las restricciones definidas para generar una propuesta de programación académica.

El desarrollo se realizará progresivamente, comenzando por la base del sistema y avanzando hasta la implementación e integración del motor de generación de horarios.

---

## Semana 1 — Base del proyecto y entidades

**Periodo:** 29 de agosto – 4 de septiembre

### Objetivo

Establecer la base técnica del proyecto e implementar las entidades principales del modelo de datos.

### Actividades

- Revisar la estructura actual del proyecto Spring Boot.
- Configurar PostgreSQL.
- Verificar la configuración de JPA/Hibernate.
- Crear las entidades:
  - `Docente`
  - `Curso`
  - `Aula/Ambiente`
  - `NRC`
  - `BloqueHorario`
- Verificar la conexión con la base de datos.
- Verificar la creación y persistencia de las entidades.

### Resultado esperado

Contar con la estructura inicial del sistema y las entidades principales funcionando correctamente con la base de datos.

---

## Semana 2 — Relaciones y persistencia

**Periodo:** 5 – 11 de septiembre

### Objetivo

Implementar las relaciones definidas en el modelo entidad-relación y garantizar la persistencia de la información.

### Actividades

- Implementar `DocenteCurso`.
- Implementar la relación `Docente → DocenteCurso`.
- Implementar la relación `Curso → NRC`.
- Implementar la relación reflexiva `NRC → NRC`.
- Implementar la relación `NRC → BloqueHorario`.
- Implementar la relación `BloqueHorario → Aula/Ambiente`.
- Crear los `Repository`.
- Realizar pruebas de persistencia.

### Resultado esperado

Contar con un modelo de datos funcional que permita almacenar y consultar correctamente la información necesaria para el motor de generación.

---

## Semana 3 — Servicios y reglas de negocio

**Periodo:** 12 – 18 de septiembre

### Objetivo

Implementar la lógica de negocio necesaria para preparar la información que utilizará el motor de generación.

### Actividades

- Crear las interfaces `Service`.
- Implementar `ServiceImpl`.
- Implementar validaciones.
- Implementar la gestión de docentes.
- Implementar la gestión de cursos.
- Implementar la gestión de horas de dictado.
- Implementar la gestión de disponibilidad docente.
- Implementar la gestión de aulas/ambientes.
- Implementar la gestión de bloques horarios.
- Aplicar las reglas de negocio definidas.

### Resultado esperado

Contar con servicios capaces de proporcionar al motor información válida y consistente.

---

## Semana 4 — Disponibilidad y preparación del motor

**Periodo:** 19 – 25 de septiembre

### Objetivo

Preparar la información y las estructuras necesarias para adaptar el motor de generación de la primera versión de Kairos.

### Actividades

- Implementar el registro de disponibilidad docente.
- Implementar los turnos:
  - Mañana
  - Tarde
  - Noche
- Validar los rangos horarios establecidos por la universidad.
- Preparar los bloques horarios que utilizará el motor.
- Identificar las restricciones que deberá considerar el motor.
- Revisar el funcionamiento del motor de la primera versión de Kairos.
- Adaptar la metodología utilizada anteriormente al nuevo modelo de datos.

### Resultado esperado

Contar con los datos y estructuras necesarias para ejecutar el motor de generación sobre la nueva versión de Kairos.

---

## Semana 5 — Motor de generación de horarios

**Periodo:** 26 de septiembre – 2 de octubre

### Objetivo

Implementar e integrar el motor de generación de horarios como componente principal del MVP.

### Actividades

- Adaptar el motor de generación de la primera versión de Kairos.
- Integrar docentes y su disponibilidad.
- Integrar cursos y horas de dictado.
- Integrar bloques horarios.
- Integrar aulas/ambientes.
- Aplicar las reglas de negocio durante la generación.
- Evitar cruces de horarios.
- Validar la disponibilidad de docentes.
- Validar la disponibilidad de ambientes.
- Generar propuestas de horarios.
- Mantener una velocidad de respuesta similar a la primera versión de Kairos.

### Resultado esperado

El sistema deberá ser capaz de generar una propuesta de programación académica utilizando la información registrada y las restricciones definidas.

---

## Semana 6 — Integración, pruebas y correcciones

**Periodo:** 3 – 4 de octubre

### Objetivo

Validar el funcionamiento completo del MVP y realizar los ajustes necesarios para su presentación o piloto.

### Actividades

- Realizar pruebas del flujo completo.
- Probar diferentes disponibilidades docentes.
- Probar diferentes combinaciones de cursos.
- Validar las reglas de negocio.
- Verificar que no existan conflictos de horarios.
- Verificar la asignación correcta de ambientes.
- Comparar el rendimiento con la primera versión de Kairos.
- Corregir errores.
- Cargar datos de prueba.
- Preparar la versión para el piloto.

### Resultado esperado

Contar con un MVP funcional de Kairos capaz de generar propuestas de programación de horarios bajo las restricciones definidas.

---

## Alcance del MVP

El MVP estará orientado a automatizar parte del **Proceso de Programación de Horarios Académicos**, considerando:

- Registro de docentes.
- Registro de cursos.
- Relación docente–curso.
- Horas de trabajo de los docentes.
- Disponibilidad docente.
- Cursos y horas de dictado según syllabus.
- NRC.
- Bloques horarios.
- Aulas/Ambientes.
- Reglas de negocio.
- Motor de generación de horarios.

### Flujo principal

**Docente → Disponibilidad → Cursos y horas → Restricciones → Motor de generación → Propuesta de horarios**

---

## Criterio de finalización

El MVP se considerará listo cuando:

- Las entidades y relaciones estén implementadas.
- La información pueda registrarse y persistirse correctamente.
- Las reglas de negocio principales estén implementadas.
- La disponibilidad de los docentes pueda utilizarse como entrada del proceso.
- El motor de generación pueda utilizar la información almacenada.
- El sistema pueda generar una propuesta de programación.
- Se controlen los principales conflictos de horarios.
- Se considere la disponibilidad de los ambientes requeridos.
- El rendimiento del motor sea aceptable y mantenga la metodología utilizada en la primera versión de Kairos.
- El flujo completo pueda probarse con datos de prueba.
- No existan errores críticos que impidan la demostración del MVP.