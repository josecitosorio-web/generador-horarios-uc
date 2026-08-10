# Kairos 🗓️

**Generador inteligente de horarios universitarios.** Selecciona tus cursos, indica tu preferencia de turno, y Kairos calcula automáticamente las mejores combinaciones de horario sin cruces, en milisegundos.

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-brightgreen?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-blue?logo=postgresql)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?logo=thymeleaf)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven)
![Deployed on Railway](https://img.shields.io/badge/Deployed-Railway-9146FF?logo=railway)

---

## El problema

En la Universidad Continental (Perú), armar un horario de matrícula sin cruces de clases —considerando además cursos con teoría y práctica ligadas— es un proceso manual que puede tomarle a un estudiante entre 1 y 2 días de prueba y error, cruzando a mano las opciones de cada curso contra las demás.

Kairos automatiza por completo ese proceso: el estudiante elige sus cursos y su preferencia de turno, y el sistema genera y rankea las mejores combinaciones válidas en cuestión de milisegundos.

## Cómo funciona

### Modelo de dominio

El diseño de datos gira en torno a tres entidades:

- **`Curso`** — la asignatura en sí (nombre, código, créditos).
- **`NRC`** — una sección específica de un curso, con su docente y modalidad. Tiene un campo `esPrincipal` que indica si es una opción que el estudiante elige directamente.
- **`BloqueHorario`** — cada franja de tiempo (día, hora de inicio, hora de fin) que pertenece a un NRC. Un mismo NRC puede tener varios bloques repartidos en distintos días de la semana.

La pieza más interesante del modelo es una **relación reflexiva** dentro de `NRC`, a través del campo `nrcVinculado` (un NRC que apunta a otro NRC de la misma tabla). Esto resuelve un caso real de la oferta académica: cursos donde la teoría y la práctica van ligadas. El estudiante solo elige el NRC principal (la teoría), y su práctica vinculada se "arrastra" automáticamente al horario, sin que el estudiante tenga que seleccionarla por separado.

### El algoritmo

El corazón de Kairos es un **backtracking recursivo** que arma el horario curso por curso:

1. Por cada curso, prueba sus NRC disponibles uno a uno.
2. Antes de aceptar un NRC, verifica si sus bloques de horario cruzan con los ya elegidos. Si hay cruce, descarta esa rama de inmediato y prueba la siguiente opción, sin seguir explorándola.
3. Si es compatible, lo agrega al horario en construcción y avanza recursivamente al siguiente curso.
4. Al completar todos los cursos sin cruces, el horario resultante queda registrado como una combinación válida.

**Poda por reordenamiento:** antes de iniciar la búsqueda, los cursos se ordenan de menor a mayor cantidad de NRC disponibles. Procesar primero los cursos con menos alternativas reduce el árbol de búsqueda desde las primeras ramas, en vez de descubrir las restricciones más fuertes recién al final del recorrido.

**Sistema de ranking:** cada horario válido se evalúa con una función de puntaje que penaliza:
- Los minutos de tiempo muerto entre clases del mismo día (excluyendo explícitamente el bloque de almuerzo institucional, que no cuenta como tiempo muerto).
- La mezcla de turnos, si el estudiante indicó una preferencia (mañana o tarde) y el horario generado combina bloques de ambos turnos.

Los horarios con menor puntaje (menos horas muertas, mejor ajuste a la preferencia) se consideran los mejores.

## Decisiones de diseño y optimización de rendimiento

La primera versión del algoritmo funcionaba correctamente, pero no escalaba: con selecciones de hasta 8 cursos, los tiempos de respuesta llegaban a varios segundos y, en los casos con más combinaciones válidas posibles, el proceso llegaba a agotar la memoria disponible en el entorno de despliegue (Railway).

Se identificaron y resolvieron dos cuellos de botella reales:

**1. Consultas repetidas a la base de datos dentro del árbol de búsqueda.** La implementación original consultaba la base de datos (NRC elegibles de un curso, bloques de horario de un NRC) en cada nodo del árbol de backtracking, lo que significaba cientos o miles de consultas redundantes por cada generación de horario, ya que esos datos no cambian durante la búsqueda. La solución fue precargar toda esa información una única vez, antes de iniciar la recursión, en estructuras en memoria (`Map`), y hacer que el backtracking trabajara exclusivamente contra esos datos ya cargados. Esto redujo el número de consultas de miles a unas pocas decenas por solicitud, y el tiempo de respuesta bajó de forma proporcional.

**2. Consumo de memoria sin límite.** La implementación original generaba y almacenaba en memoria *todas* las combinaciones válidas encontradas por el árbol, para recién al final ordenarlas y quedarse con las 5 mejores. En selecciones de cursos con pocas restricciones entre sí, esto podía significar acumular miles de horarios completos en memoria simultáneamente, lo cual provocaba caídas del proceso por falta de memoria. La solución fue mantener, durante todo el recorrido del árbol, únicamente los 5 mejores horarios encontrados hasta ese momento: cada nuevo horario válido se compara contra el peor de los 5 ya guardados, reemplazándolo solo si el nuevo es mejor. El árbol se sigue explorando por completo —no se pierde ningún resultado válido—, pero el consumo de memoria para almacenar resultados se mantiene constante, sin importar cuántas combinaciones válidas existan en total.

## Características principales

- **Módulo de administración**, con CRUD completo de Cursos, NRC y Bloques de Horario, incluyendo validaciones de integridad (por ejemplo, no se puede eliminar un curso que tiene NRC asociados).
- **Vista de horario semanal por NRC**, para revisar visualmente la carga horaria de una sección específica antes de elegirla.
- **Flujo de generación para el estudiante**: selección de cursos + preferencia de turno → hasta 5 horarios recomendados, ordenados de mejor a peor → vista detallada de cada horario en formato de tabla semanal.

## Validaciones de negocio

- Mínimo de 12 créditos por selección, replicando la regla real de matrícula de la universidad.
- Máximo de 8 cursos por consulta, como medida de protección de estabilidad del sistema.
- Manejo explícito del caso "no se encontró ninguna combinación válida", sin fallos ni comportamientos inesperados.

## Problemas encontrados y cómo se resolvieron

> [PENDIENTE: completar con los problemas específicos]

## Stack técnico

| Capa | Tecnología |
|---|---|
| Backend | Java 17, Spring Boot, Spring Data JPA / Hibernate |
| Frontend | Thymeleaf, HTML, CSS, JavaScript |
| Base de datos | PostgreSQL (persistente), H2 (desarrollo local) |
| Build / gestión de dependencias | Maven |
| Control de versiones | Git / GitHub |
| Despliegue | Railway |

## Cómo correrlo localmente

**Requisitos:** Java 17+, Maven, y (opcionalmente) una instancia de PostgreSQL — el proyecto usa H2 en memoria por defecto para desarrollo local.

```bash
# Clonar el repositorio
git clone <url-del-repositorio>
cd genedor-horarios

# Compilar y correr con Maven Wrapper
./mvnw spring-boot:run
```

La aplicación quedará disponible en `http://localhost:8080`.

Para conectarla a una base de datos PostgreSQL propia en vez de H2, configura las variables correspondientes en `src/main/resources/application.properties`.

## Demo en producción

🔗 **[Ver Kairos en vivo](https://kairosjc.up.railway.app/bienvenida)**

*(el sistema fue validado con datos reales de la oferta académica y verificado manualmente, comparando los horarios generados contra combinaciones armadas a mano)*

---

Proyecto personal desarrollado como parte de mi formación en Ingeniería de Software.
