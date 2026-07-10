-- creacion de los cursos a evaluar
INSERT INTO Curso (codigo, nombre, creditos) VALUES ('ASUC01141', 'ARQUITECTURA EMPRESARIAL', 5);--1
INSERT INTO Curso (codigo, nombre, creditos) VALUES ('ASUC00947', 'CONSTRUCCION DE SOFTWARE', 5);--2
INSERT INTO Curso (codigo, nombre, creditos) VALUES ('ASUC00754', 'REDES DE COMPUTADORES', 4);--3
INSERT INTO Curso (codigo, nombre, creditos) VALUES ('ASUC00466', 'INGENIERIA ECONOMICA', 3);--4
INSERT INTO Curso (codigo, nombre, creditos) VALUES ('ASUC01365', 'INNOVACION SOCIAL', 2);--5
INSERT INTO Curso (codigo, nombre, creditos) VALUES ('ASUC01341', 'GESTION PROFESIONAL', 1);--6

-- creacion de los nrcs
INSERT INTO NRC ( codigo, docente, modalidad, es_principal, curso_id )
VALUES ('31674', 'RUIZ PAREJAS, RUBEN ANGEL', 'Fisica', true , 1);--1

INSERT INTO NRC ( codigo, docente, modalidad, es_principal, curso_id , nrc_vinculado_id )
VALUES ('31670', 'RUIZ PAREJAS, RUBEN ANGEL', 'Fisica', false , 1 , 1);--2

INSERT INTO NRC ( codigo, docente, modalidad, es_principal, curso_id )
VALUES ('28611', 'ZARATE MENDOZA, ROBERTO', 'Fisica', true , 2);--3

INSERT INTO NRC ( codigo, docente, modalidad, es_principal, curso_id )
VALUES ('41374', 'HUAMANI BREÑA, DIANA TRILCE', 'Remota', true , 6);--4

INSERT INTO NRC ( codigo, docente, modalidad, es_principal, curso_id )
VALUES ('29438', 'VILCHEZ BACA, HERBERT ANTONIO', 'Remoto', true , 4);--5

INSERT INTO NRC ( codigo, docente, modalidad, es_principal, curso_id , nrc_vinculado_id )
VALUES ('29439', 'VILCHEZ BACA, HERBERT ANTONIO', 'Remoto', false , 4 , 5);--6

INSERT INTO NRC ( codigo, docente, modalidad, es_principal, curso_id )
VALUES ('27869', 'CAJACHAGUA GUERREROS, DIEGO RICARDO', 'Hibrida', true , 5);--7

INSERT INTO NRC ( codigo, docente, modalidad, es_principal, curso_id )
VALUES ('31636', 'CONDORI TORRES, GIANCARLO', 'Fisica', true , 3);--8


-- ============================
-- ARQUITECTURA EMPRESARIAL
-- ============================

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('31675','RUIZ PAREJAS, RUBEN ANGEL','Fisica',true,1); --9

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id,nrc_vinculado_id)
VALUES ('31676','RUIZ PAREJAS, RUBEN ANGEL','Fisica',false,1,9); --10

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('31677','QUISPE LOPEZ, MIGUEL ANGEL','Fisica',true,1); --11

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id,nrc_vinculado_id)
VALUES ('31678','QUISPE LOPEZ, MIGUEL ANGEL','Fisica',false,1,11); --12


-- ============================
-- CONSTRUCCIÓN DE SOFTWARE
-- ============================

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('28613','ZARATE MENDOZA, ROBERTO','Fisica',true,2); --13

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id,nrc_vinculado_id)
VALUES ('28614','ZARATE MENDOZA, ROBERTO','Fisica',false,2,13); --14

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('28615','PEREZ SALAZAR, LUIS ENRIQUE','Fisica',true,2); --15

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id,nrc_vinculado_id)
VALUES ('28616','PEREZ SALAZAR, LUIS ENRIQUE','Fisica',false,2,15); --16


-- ============================
-- REDES DE COMPUTADORES
-- ============================

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('31637','CONDORI TORRES, GIANCARLO','Fisica',true,3); --17

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('31638','RAMOS FLORES, EDWIN','Fisica',true,3); --18

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('31639','RAMOS FLORES, EDWIN','Fisica',true,3); --19


-- ============================
-- INGENIERÍA ECONÓMICA
-- ============================

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('29440','VILCHEZ BACA, HERBERT ANTONIO','Remoto',true,4); --20

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id,nrc_vinculado_id)
VALUES ('29441','VILCHEZ BACA, HERBERT ANTONIO','Remoto',false,4,20); --21

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('29442','GUTIERREZ ROJAS, CARLOS','Remoto',true,4); --22

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id,nrc_vinculado_id)
VALUES ('29443','GUTIERREZ ROJAS, CARLOS','Remoto',false,4,22); --23


-- ============================
-- INNOVACIÓN SOCIAL
-- ============================

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('27870','CAJACHAGUA GUERREROS, DIEGO RICARDO','Hibrida',true,5); --24

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('27871','CAJACHAGUA GUERREROS, DIEGO RICARDO','Hibrida',true,5); --25

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('27872','MENDOZA SOTO, MARIA ELENA','Virtual',true,5); --26


-- ============================
-- GESTIÓN PROFESIONAL
-- ============================

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('41375','HUAMANI BREÑA, DIANA TRILCE','Remota',true,6); --27

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('41376','HUAMANI BREÑA, DIANA TRILCE','Remota',true,6); --28

INSERT INTO NRC (codigo, docente, modalidad, es_principal, curso_id)
VALUES ('41377','ROJAS FLORES, KARINA','Remota',true,6); --29


--creacion de los bloques de horario
INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MARTES', '17:20', '18:49' , 'Sala Meet' , 4);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MARTES', '19:00', '20:29' , 'J301' , 8);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MIERCOLES', '14:00', '15:29' , 'I603' , 2);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MIERCOLES', '15:40', '17:09' , 'I603' , 2);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MIERCOLES', '17:20', '18:49' , 'J301' , 8);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MIERCOLES', '19:00', '20:29' , 'J301' , 8);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('JUEVES', '10:20', '11:49' , 'C101' , 7);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('JUEVES', '12:00', '13:29' , 'C101' , 7);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('JUEVES', '14:00', '15:29' , 'I603' , 1);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('VIERNES', '14:20', '15:29' , 'I501' , 3);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('VIERNES', '15:40', '17:09' , 'I501' , 3);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('SABADO', '10:20', '11:49' , 'J301' , 3);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('SABADO', '15:40', '17:09' , 'Sala Meet' , 5);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('SABADO', '17:10', '18:39' , 'Sala Meet' , 6);

-- =====================================================
-- ARQUITECTURA EMPRESARIAL
-- =====================================================

-- NRC 9 (31675) - TEORIA

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('LUNES','14:00','15:29','I604',9);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('LUNES','15:40','17:09','I604',9);

-- NRC 10 (31676) - PRACTICA

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MIERCOLES','14:00','15:29','I604',10);

------------------------------------------------------------

-- NRC 11 (31677) - TEORIA

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MARTES','19:00','20:29','I605',11);

-- NRC 12 (31678) - PRACTICA

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('JUEVES','19:00','20:29','I605',12);

------------------------------------------------------------

-- NRC 1 (31674) - TEORIA (YA EXISTE)
-- Agregamos el bloque faltante del viernes

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('VIERNES','14:00','15:29','I603',1);

------------------------------------------------------------

-- NRC 2 (31670) - PRACTICA (YA EXISTE)
-- Ya posee:
-- MIERCOLES 14:00-15:29
-- MIERCOLES 15:40-17:09

-- =====================================================
-- CONSTRUCCIÓN DE SOFTWARE
-- =====================================================

------------------------------------------------------------
-- NRC 3 (28611) - TEORIA (YA EXISTE)
-- Ya tiene:
-- Viernes 14:00 - 15:29
-- Viernes 15:40 - 17:09
-- Sábado 10:20 - 11:49

-- NRC 13 (28613) - TEORIA

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('LUNES','19:00','20:29','I501',13);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MIERCOLES','19:00','20:29','I501',13);

------------------------------------------------------------

-- NRC 14 (28614) - LABORATORIO

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('VIERNES','17:20','18:49','LAB-C1',14);

------------------------------------------------------------

-- NRC 15 (28615) - TEORIA

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MARTES','17:20','18:49','I502',15);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MARTES','19:00','20:29','I502',15);

------------------------------------------------------------

-- NRC 16 (28616) - LABORATORIO

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('JUEVES','17:20','18:49','LAB-C2',16);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('JUEVES','19:00','20:29','LAB-C2',16);

-- =====================================================
-- REDES DE COMPUTADORES
-- =====================================================

------------------------------------------------------------
-- NRC 17 (31637)

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('LUNES','07:00','08:29','J302',17);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('LUNES','08:40','10:09','J302',17);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('VIERNES','07:00','08:29','J302',17);

------------------------------------------------------------
-- NRC 18 (31638)

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('JUEVES','17:20','18:49','J303',18);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('JUEVES','19:00','20:29','J303',18);

------------------------------------------------------------
-- NRC 19 (31639)

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MARTES','10:20','11:49','J304',19);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MARTES','12:00','13:29','J304',19);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('VIERNES','10:20','11:49','J304',19);



-- =====================================================
-- INGENIERÍA ECONÓMICA
-- =====================================================

------------------------------------------------------------
-- NRC 20 (29440) - TEORIA

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MARTES','10:20','11:49','Sala Meet',20);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MARTES','12:00','13:29','Sala Meet',20);

------------------------------------------------------------
-- NRC 21 (29441) - PRACTICA

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('SABADO','12:00','13:29','Sala Meet',21);

------------------------------------------------------------
-- NRC 22 (29442) - TEORIA

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('LUNES','17:20','18:49','Sala Meet',22);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('LUNES','19:00','20:29','Sala Meet',22);

------------------------------------------------------------
-- NRC 23 (29443) - PRACTICA

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('VIERNES','19:00','20:29','Sala Meet',23);

-- =====================================================
-- INNOVACIÓN SOCIAL
-- =====================================================

------------------------------------------------------------
-- NRC 24 (27870)

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('LUNES','07:00','08:29','C102',24);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('LUNES','08:40','10:09','C102',24);

------------------------------------------------------------
-- NRC 25 (27871)

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MIERCOLES','17:20','18:49','C103',25);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MIERCOLES','19:00','20:29','C103',25);

------------------------------------------------------------
-- NRC 26 (27872)

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MARTES','19:00','20:29','Sala Meet',26);

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('JUEVES','19:00','20:29','Sala Meet',26);

-- =====================================================
-- GESTIÓN PROFESIONAL
-- =====================================================

------------------------------------------------------------
-- NRC 27 (41375)

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('LUNES','10:20','11:49','Sala Meet',27);

------------------------------------------------------------
-- NRC 28 (41376)

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('MIERCOLES','19:00','20:29','Sala Meet',28);

------------------------------------------------------------
-- NRC 29 (41377)

INSERT INTO BloqueHorario (dia, hora_inicio, hora_fin, aula, nrc_id)
VALUES ('JUEVES','12:00','13:29','Sala Meet',29);