# PRIMERA REUNIÓN SOBRE KAIROS

**Fecha:** 25 de agosto del 2026

**Participantes :** Osorio Blancas José Carlos, Ing. Yan Casaico

**Tema :** Coordinación sobre al elaboración del piloto de Kairos y ampliación del sistema para la generación de los horarios de los docentes en abse a su disponibilidad 


---

## 1.- OBJETIVO DE LA REUNIÓN

Se planteó realizar un piloto de Kairos para apoyar el proceso de generación de horarios de la carrera.

Se establecieron 2 pruebas :

- Primera prueba : periodo de verano
- Segunda prueba : pendiente de precisar. En las anotaciones se menciona una prueba para "jurados"
  
El sistema debería estar listo como máximo para noviembre

---

## 2.- NUEVA FUNCIONALIDAD PLANTEADA

Además de la generación de horarios para estudiantes, se planteó incorporar una funcionalidad para trabajar con la disponibilidad de los docentes.

La idea general planteada fue :

> los docentes indican los días y/o turnos en los que tienen disponibilidad y, a partir de esta información, se generan sus bloques horarios.

Ejemplo mencionado durante la reunión :

> Tengo disponible lunes y martes toda la mañana

---

## 3.- Información de los docentes

Se planteó que los docentes puedan proporcionar su información mediante archivos CSV.

Inicialmente, para las pruebas , el CSV puede ser genérico y utilizar docentes simulados 

Información mínima considerada inicialmente: 

- Nombre del docente
- Disponibilidad
- Turno: Mañana / Tarde

La estructura definitiva del CSV queda pendiente de definir .

---

## 4.- CURSOS

Se planteó trabajar con los cursos correspondientes a los diferentes ciclos.

También se mencionó la necesidad de contar con una lista general de cursos organizada pro pestañas según el ciclo 

Los cursos generales podrán ser simulados inicialmente para las pruebas.

---

## 5.- CURSOS DE ESPECIALIDAD

Se indicó en la reunión que los cursos de especialidad deben llevarse en aulas/laboratorios de especialidad.

Por lo tanto:

- Los cursos de especialidad deben considerar la disponibilidad de los laboratorios.
- Los cursos de especialidad deben asignarse a las aulas/laboratorios de especialidad.

---

## 6.- LABORATORIOS Y AULAS 

Se indicó que la generación debe considerar la disponibilidad de los laboratorios.

Para la primera version:

- Se dejará fuera el manejo general de todas las aulas
- Se trabajará principalmente con las aulas/laboratorios de especialidad
- Se deberá analizar la cantidad máxima/disponibilidad de las aulas de especialidad

> Pendiente: precisar qué significa exactamente "poner como máximo" para las aulas de especialidad

---

## 7.- REGLAS MENCIONADAS

Durante la reunión se mencionaron las siguientes reglas o consideraciones :

- La generación depende de la disponibilidad de los laboratorios
- La generación depende de la disponibilidad de los docentes.
- Los cursos de especialidad tienen prioridad.
- Los cursos de especialidad deben utilizar laboratorios/aulas de especialidad.
- No deberían existir cruces entre cursos
- Los cursos de otros ciclos no deben chocarse con otros cursos de otros ciclos
  
---

## 8.- Generación de horarios para estudiantes

Una vez generados los bloques y horarios, estos será utilizados para el proceso de matrícula de los estudiantes.

Se indicó que:

- Los estudiantes utilizarán los horarios generados.
- Los horarios no se integrarán directamente con el portal del estudiante.
- Una vez listos, serán compartidos con los estudiantes mediante correo.

---

## 9.- ALCANCE INICIAL / DECISIONES

Para evitar aumentar demasiado el alcance inicial, se planteó:

- Utilizar un CSV genérico para las primera pruebas.
- Utilizar docentes simulados inicialmente.
- Simular los cursos generales.
- No implementar inicialmente el manejo completo de aulas.
- Trabajar inicialmente con aulas/laboratorios de especialidad.
- No realizar integración con el portal del estudiante.

---

## 10.- PRUEBAS Y PILOTO

Se plantearon dos pruebas:

### PRUEBA 1
Periodo verano

### PRUEBA 2
Pendiente de precisar

En las anotaciones se menciona :

> Para los jurados otra prueba

Se debe confirmar qué significa esta segunda prueba y cuál será exactamente su periodo o propósito.

---

## 11.- FECHA LÍMITE

El sistema deberá estar listo como máximo para:

**NOVIEMBRE DEL 2026**

Se busca contar con una primera versión/avance antes de esa fecha para poder realizar pruebas y validaciones.

---

## 12.- INFORMACIÓN PENDIENTE DE ACLARAR

- Formato decisivo el CSV
- Información exacta que proporcionará cada docente
- Forma exacta en que se declara la disponibilidad
- Manejo de las horas de trabajo/carga horaria de los docentes
- Forma exacta en la que se declara la disponibilidad
- Forma en que se asignan los cursos a los docentes
- Reglas exactas para evitar cruces 
- Significado exacto de la prioridad de los cursos de especialidad 
- Disponibilidad y restricciones de los laboratorios
- Significado de "poner como máximo" para las aulas de especialidad
- Alcance de la segunda prueba mencionada como "jurados"