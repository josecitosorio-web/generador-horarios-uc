# ACTORES Y ENTIDADES

## 1.- ACTORES :

- **Docentes :** Son aquellos que mencionarán los cursos, sus horas laborales, disponibilidad (en base a los turnos mañana,tarde y noche)
- **Programación :** Son aquellos quien en base a la disponibilidad que brindan los docentes ellos sacan las posibles ofertas horarias
- **Estudiante :** Son aquellos quienes en base a la oferta horaria que brindan programación obtienen sus horarios de clases en base a los ursos que van a llevar
  
## 2.- ENTIDADES :
- **Docente :** Aquel que dicta clases pero nos brindará su disponibilidad (en base a los turnos), horas laborales, cursos que dictará
- **Curso :** Asignatura o temática la cual el docente se encargará de dictar (sus atributos estan casi definidos en el modelo de base de datos anterior) y cumplirán sus horas de dictado en base al syllabus
- **Aula/Ambiente :** Lugar donde se desarrollarán las clases por los docentes se dividirán en aulas para netamente especialdiad de la carrera y cursos para dictar teoría
- **NRC :** Código unico que identifica a la clase de cada docente
- **BloqueHorario :** Espacio o tiempo establecido donde se dictará las clases por los docentes

## 3.- RELACIÓN INICIAL ENTRE ELLOS :

Las relaciones que se plantearán es una aproximación al proceso original, para el MVP las relaciones que se manejarán hasta ahora son :
- **Docente -> Curso :** un docente puede dictar muchos cursos, y un curso es dictado por muchos docentes (relacion N:N).
- **Curso -> NRC :** Un curso puede tener muchos NRCs pero un NRC pertenece a un solo curso (relación 1:N).
- **NRC -> NRC :** Un NRC puede estar ligado a otro NRC, pero un NRC solo esta ligado a un solo NRC (relación 1:N).
- **NRC -> BloqueHorario :** Un NRC puede tener varios bloques de horario, pero un bloque de horario pertenece a un solo NRC (relación 1:N). 
- **BloqueHorario -> Aula/Ambiente :** Un bloque horario esta relacionado a un solo aula/ambiente, pero un aula/ambiente esta realacionado a varios bloques de horario (relación 1:N).
