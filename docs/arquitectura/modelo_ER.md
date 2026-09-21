@startuml
top to bottom direction

skinparam classAttributeIconSize 0
skinparam linetype ortho

entity "DocenteCurso" as DocenteCurso {
    * docente_id : bigint <<PK, FK>>
    * curso_id : bigint <<PK, FK>>
}

entity "Docente" as Docente {
    * id : bigint <<PK>>
    --
    nombre : string
    horas_laborales : int
}

entity "Curso" as Curso {
    * id : bigint <<PK>>
    --
    codigo : string
    creditos : int
    nombre : string
    horas_teoricas : int
    horas_practicas : int
}

entity "NRC" as NRC {
    * id : bigint <<PK>>
    --
    curso_id : bigint <<FK>>
    docente_id : bigint <<FK>>
    nrc_vinculado_id : bigint <<FK>>
    codigo : int
    modalidad : string
    es_principal : boolean
}

entity "Aula/Ambiente" as Aula {
    * id : bigint <<PK>>
    --
    codigo : string
    tipo : enum
}

entity "BloqueHorario" as BloqueHorario {
    * id : bigint <<PK>>
    --
    nrc_id : bigint <<FK>>
    aula_ambiente_id : bigint <<FK>>
    diaSemana : string
    hora_inicio : timestamp
    hora_fin : timestamp
}

' =========================
' FORZAR POSICIONES
' =========================

Docente -[hidden]right- Curso
NRC -[hidden]right- Aula
BloqueHorario -[hidden]up- NRC

' =========================
' RELACIONES
' =========================

DocenteCurso ||--o{ Docente
DocenteCurso ||--o{ Curso

Docente ||--o{ NRC
Curso ||--o{ NRC

NRC ||--o{ BloqueHorario
Aula ||--o{ BloqueHorario

NRC ||--o{ NRC : vinculado

@enduml