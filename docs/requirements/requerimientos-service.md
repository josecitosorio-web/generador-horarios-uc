# REQUERIMIENTOS RELACIONAS EN BASE A SUS SERVICES
Los requerimientos redactado a continuación estaran relacionados en base a sus entidades que tienes influencia e impactan mas :
## DocenteService
- [X] RF-02: El sistema deberá permitir al administrador registrar a los docentes.
- [X] RF-03: El sistema deberá permitir registrar las horas de trabajo asignadas a cada docente.
- [X] RF-04: El sistema deberá permitir registrar la disponibilidad horaria de los docentes.
- [X] RN-05: La disponibilidad declarada por el docente debe corresponder a periodos de tiempo en los que puede ser programado para dictar clases (mañana, tarde o noche).
- [X] RN-07: La cantidad de horas programadas para un docente debe considerar la carga horaria correspondiente a los cursos que tiene asignados.
- [X] RN-16: La disponibilidad del docente debe declararse indicando el turno o los turnos en los que tiene disponibilidad: mañana, tarde o noche.
---
## CursoService
- [X] RF-01: El sistema deberá permitir al administrador registrar los cursos correspondientes a los planes de estudio de la carrera de Ingeniería de Sistemas e Informática.
- [X] RF-05: El sistema deberá permitir registrar la cantidad de horas de dictado requeridas para cada curso, de acuerdo con su syllabus.
- [X] RN-08: La programación de un curso debe cumplir con la cantidad de horas de dictado establecidas en su syllabus.
---
## AulaAmbienteService
- [X] RF-07: El sistema deberá permitir registrar las aulas y ambientes disponibles para la programación.
---
## NrcService
- [ ] RN-01: Los cursos de especialidad de la carrera de Ingeniería de Sistemas e Informática deben dictar sus horas prácticas en aulas de especialidad, específicamente en las aulas J301 y J302.
- [ ] RN-02: Los cursos "REDES DE COMPUTADORES", "CONMUTACIÓN Y ENRUTAMIENTO", "ESCALAMIENTO DE REDES COMPUTADORAS" y "REDES WAN" se deben dictar tanto sus horas teóricas como prácticas en el aula J301.
- [ ] RN-03: Los cursos de especialidad (de la carrera de ing. de Sistemas e Informática) se puede que dictar las horas de teoría en otras aulas (de preferencia en el pabellón I).
---
## BloqueHorarioService
- [X] RF-06: El sistema deberá permitir registrar los bloques horarios establecidos por la universidad.
- [ ] RN-04: Todos los bloques de horarios deben respetar el rango establecido por la universidad (guiarse de la primera versión de Kairos).
- [ ] RN-06: La programación de las horas de clase de un docente debe realizarse dentro de los periodos de disponibilidad que este haya declarado.
- [ ] RN-09: Un docente no puede tener dos cursos programados en el mismo bloque horario.
- [ ] RN-10: Un aula o ambiente no puede ser asignado a más de un curso en el mismo bloque horario.
- [ ] RN-12: La programación de cursos debe considerar la disponibilidad de los ambientes y laboratorios requeridos para su desarrollo.
- [ ] RN-13: Los bloques horarios del turno mañana deben encontrarse dentro del rango de 07:00 a 13:30.
- [ ]  RN-14: Los bloques horarios del turno tarde deben encontrarse dentro del rango de 14:00 a 18:50.
- [ ] RN-15: Los bloques horarios del turno noche deben encontrarse dentro del rango de 19:00 a 22:30.
---
## MOTOR DE GENERACION
- [ ] RN-11: Los cursos que puedan ser llevados simultáneamente por los estudiantes no deben presentar cruces de horario.  
