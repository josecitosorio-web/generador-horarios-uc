# BITÁCORA DE DESARROLLO - KAIROS V2

## 31/08/2026
### Realizado
- Se hizo la creación de una nueva base de datos llamado kairos_v2 en pgAdmin
- Se hizo el cambio de conexion a la nueva base de datos en application.propoerties
- Creación de la nueva entidad **DOCENTE**
- Creación de la entidad intermediadia **DOCENTECURSO**
- Creación de la relación 1:N de la entidad **DOCENTE** hacia la entidad **DOCENTECURSO**
- Modificación y/o actualización de la entidad **CURSO** en base al nuevo modelo de base de datos (agregación del atributo horas)
- Creación de la realación 1:N de la entidad **CURSO** hacia la entidad **DOCENTECURSO**
- Edicion de la entidad **NRC** en base al nuevo modelo de base de datos
- Verificación de mantenibilidad de las relaciones de la entidad **NRC** con las identidades **CURSO** y **BLOQUE HORARIO**

## 02/09/2026
### Realizado
- Cambio y actualización del adapter de la entidad **NrcAdapter**
- Actualización de la entidad **BloqueHorario** en base al nuevo modelo entidad relacion
- Creación de la nueva entidad **AulaAmbienteEntity** 
- Creación de la relación 1:N de la entidad **AulaAmbiente** con la entidad **BloqueHorario**
- Correción y actualización de las pruebas realizadas al motor de busqueda en base al nuevo constructor de **BloqueHorario**
- Correción del modelo de base de datos
- Creación de la nueva relacion de 1:N de la entidad **Docente** hacia la entidad **Nrc**

## 05/09/2026
### Realizado
- creación del controlador para el campo aula-ambiente
- creación de la interfaz del servicio de aula-ambiente
- creación de la implementacion del servicio de aula-ambiente
- creación del modelo de aula-ambiente
- creación del repository de aula-ambiente
- creación del modelo de docente
- creación de la interfaz del servicio de docente
- creación de la implementación del servicio docente
- creación del controlador para el campo docente
- creación del repository de docente
- creación del adapter de aula-ambiente
- creación del adapter de docente
- creación del test nrc para la verificación de la persistencia de datos en la nueva base de datos
- aprendizaje e implemetnacion del uso de **entityManager.flush();** y **entityManager.clear();**

## 13/09/2026
### Realizado
- creación e implementación del service de Docente
- creación e implementación del service de Aula-Ambiente
- creación del enum Turno en la carpeta docente para el manejo de disponibilidad de docentes
- creación de una tabla auxiliar con el uso de Hibernate para el tema de disponibilidad de los docentes
- creación de la funcionalidad para la carga horario en base a las horas de un docente
- creacion del model de la entidad DocenteCurso
- cración del repository de la entidad Docente Curso

## 14/09/2026
## Realizado
- creacion del service de asignacion en docentecurso con su respectiva validacion de cursos asignados
  