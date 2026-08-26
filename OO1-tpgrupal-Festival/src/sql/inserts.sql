-- SE ASUME QUE YA SE EJECUTO EL PROYECTO (LAS TABLAS DEBEN ESTAR CREADAS)
-- --------------------------------------
-- EMPLEADO
-- --------------------------------------
INSERT INTO empleado (nombre, apellido, dni, fecha_nacimiento, fecha_ingreso, id_unidad_venta) VALUES
('Juan',       'Martínez',   '30111222', '1985-03-15', '2020-01-10', NULL),
('Laura',      'Gómez',      '31222333', '1988-07-22', '2019-05-03', NULL),
('Diego',      'Fernández',  '29333444', '1982-11-30', '2018-03-12', NULL),
('Sofía',      'Rodríguez',  '33444555', '1992-02-18', '2021-06-01', NULL),
('Martín',     'López',      '28555666', '1979-09-05', '2017-08-20', NULL),
('Valentina',  'Torres',     '34666777', '1995-12-01', '2022-02-14', NULL),
('Camila',     'Sánchez',    '32777888', '1990-04-25', '2020-09-01', NULL),
('Nicolás',    'Díaz',       '31888999', '1987-01-14', '2019-11-15', NULL),
('Agustina',   'Romero',     '35999000', '1996-06-09', '2023-01-05', NULL),
('Tomás',      'Álvarez',    '30000111', '1984-10-20', '2018-07-22', NULL),
('Julieta',    'Molina',     '33111222', '1993-08-17', '2021-03-30', NULL),
('Bruno',      'Herrera',    '29222333', '1981-05-28', '2016-04-11', NULL),
('Federico',   'Silva',      '30112233', '1991-02-11', '2021-01-15', NULL),
('Rocío',      'Paz',        '31223344', '1994-05-19', '2022-03-20', NULL),
('Ignacio',    'Vega',       '29334455', '1986-09-02', '2019-07-08', NULL),
('Milagros',   'Ruiz',       '33445566', '1997-01-27', '2023-05-10', NULL),
('Franco',     'Acosta',     '28556677', '1983-12-14', '2018-02-25', NULL),
('Antonella',  'Ríos',       '34667788', '1998-03-30', '2023-08-01', NULL),
('Gonzalo',    'Ortiz',      '32778899', '1989-06-23', '2020-04-17', NULL),
('Delfina',    'Castro',     '31889900', '1995-10-08', '2022-06-12', NULL),
('Lucas',      'Medina',     '35990011', '1980-04-05', '2017-01-30', NULL),
('Catalina',   'Núñez',      '30001122', '1992-08-16', '2021-09-05', NULL),
('Emiliano',   'Vera',       '33112233', '1987-11-21', '2019-10-19', NULL),
('Renata',     'Flores',     '29223344', '1996-02-28', '2023-02-14', NULL),
('Valeria',    'Suárez',     '30223344', '1994-01-12', '2022-08-01', NULL),
('Matías',     'Correa',     '31334455', '1990-07-03', '2021-02-14', NULL),
('Brenda',     'Ibarra',     '29445566', '1988-03-22', '2019-09-09', NULL),
('Simón',      'Paredes',    '33556677', '1996-11-05', '2023-04-18', NULL),
('Abril',      'Godoy',      '28667788', '1985-06-27', '2018-05-23', NULL),
('Ramiro',     'Peña',       '34778899', '1993-09-14', '2022-11-30', NULL);

-- --------------------------------------
-- COCINERO
-- --------------------------------------
INSERT INTO cocinero (id_cocinero, especialidad, plus_categoria) VALUES
(1,  'Parrilla',        15000.0),
(2,  'Comida mexicana',  12000.0),
(3,  'Pastelería',       18000.0),
(4,  'Comida vegana',    10000.0),
(5,  'Panadería',        14000.0),
(6,  'Heladería',        11000.0),
(13, 'Parrilla',         13500.0),
(15, 'Comida mexicana',  11500.0),
(17, 'Pastelería',       16000.0),
(19, 'Comida vegana',     9500.0),
(21, 'Panadería',        12500.0),
(23, 'Heladería',        10500.0);

-- --------------------------------------
-- CAJERO
-- --------------------------------------
INSERT INTO cajero (id_cajero, turno) VALUES
(7,  'MANIANA'),
(8,  'NOCHE'),
(9,  'MANIANA'),
(10, 'NOCHE'),
(11, 'MANIANA'),
(12, 'NOCHE'),
(14, 'NOCHE'),
(16, 'MANIANA'),
(18, 'NOCHE'),
(20, 'MANIANA'),
(22, 'NOCHE'),
(24, 'MANIANA'),
(25, 'MANIANA'),
(26, 'NOCHE'),
(27, 'MANIANA'),
(28, 'NOCHE'),
(29, 'MANIANA'),
(30, 'NOCHE');

-- --------------------------------------
-- FESTIVAL
-- --------------------------------------
INSERT INTO festival (nombre, temporada, fecha_inicio, fecha_fin) VALUES
('Sabores de Primavera', 'Primavera', '2026-09-21', '2026-09-30'),
('Fiesta de Verano',     'Verano',    '2026-12-15', '2027-01-15'),
('Otoño Gourmet',        'Otoño',     '2026-04-01', '2026-04-10');

-- --------------------------------------
-- UNIDAD_VENTA
-- --------------------------------------
INSERT INTO unidad_venta (nombre_comercial, responsable, id_festival, superficie, codigo) VALUES
('El Rincón Picante', 1, 1, 12.5, 'FT-001'),
('Sabor Callejero',   2, 1, 10.0, 'FT-002'),
('Dulce Tentación',   3, 1, 8.0,  'PD-001'),
('Parrilla Andante',  4, 2, 15.0, 'FT-003'),
('Verde Vida',        5, 2, 6.5,  'PD-002'),
('Mar y Tierra',      6, 3, 14.0, 'FT-004');

UPDATE empleado SET id_unidad_venta = 1 WHERE id_empleado IN (7, 13, 14, 25);
UPDATE empleado SET id_unidad_venta = 2 WHERE id_empleado IN (8, 15, 16, 26);
UPDATE empleado SET id_unidad_venta = 3 WHERE id_empleado IN (9, 17, 18, 27);
UPDATE empleado SET id_unidad_venta = 4 WHERE id_empleado IN (10, 19, 20, 28);
UPDATE empleado SET id_unidad_venta = 5 WHERE id_empleado IN (11, 21, 22, 29);
UPDATE empleado SET id_unidad_venta = 6 WHERE id_empleado IN (12, 23, 24, 30);

-- --------------------------------------
-- FOODTRUCK
-- --------------------------------------
INSERT INTO foodtruck (id_foodtruck, patente, requiere_electricidad) VALUES
(1, 'AB123CD', 1),
(2, 'AC456DE', 0),
(4, 'AD789FG', 1),
(6, 'AE012HI', 1);

-- --------------------------------------
-- PUESTO_DESARMABLE
-- --------------------------------------
INSERT INTO puesto_desarmable (id_puesto_desarmable, cantidad_carpas, tiempo_montaje) VALUES
(3, 2, 45),
(5, 1, 30);

-- --------------------------------------
-- PLATO
-- --------------------------------------
INSERT INTO plato (nombre, precio_venta, costo_produccion, id_unidad_venta) VALUES
('Choripán',              3500.0, 1200.0, 1),
('Hamburguesa Clásica',   5200.0, 2100.0, 1),
('Papas Fritas',          2800.0, 900.0,  1),
('Limonada Natural',      2000.0, 600.0,  1),
('Empanada de Carne',     1500.0, 500.0,  2),
('Ensalada César',        3800.0, 1400.0, 2),
('Quesadilla',            3300.0, 1100.0, 2),
('Nachos con Guacamole',  4000.0, 1500.0, 2),
('Helado Artesanal',      3200.0, 1100.0, 3),
('Waffle con Frutas',     3600.0, 1300.0, 3),
('Cucurucho Doble',       2900.0, 950.0,  3),
('Alfajor Artesanal',     1600.0, 550.0,  3),
('Tacos de Pollo',        4200.0, 1600.0, 4),
('Pizza Individual',      4800.0, 1900.0, 4),
('Burrito de Pollo',      4500.0, 1700.0, 4),
('Milkshake',             2600.0, 800.0,  4),
('Ensalada Verde',        3400.0, 1200.0, 5),
('Jugo de Naranja',       1800.0, 500.0,  5),
('Smoothie Detox',        3100.0, 1000.0, 5),
('Wrap Vegano',           3900.0, 1400.0, 5),
('Bife a la Parrilla',    6500.0, 2800.0, 6),
('Papas Rústicas',        3000.0, 1000.0, 6),
('Costillas BBQ',         7200.0, 3100.0, 6),
('Provoleta',             4300.0, 1600.0, 6);

-- --------------------------------------
-- PEDIDO
-- --------------------------------------
INSERT INTO pedido (fecha, id_unidad_venta, id_festival) VALUES
('2026-09-21', 1, 1),
('2026-09-22', 1, 1),
('2026-09-23', 1, 1),
('2026-09-24', 1, 1),
('2026-09-26', 1, 1),
('2026-09-28', 1, 1),
('2026-09-22', 2, 1),
('2026-09-23', 2, 1),
('2026-09-25', 2, 1),
('2026-09-27', 2, 1),
('2026-09-29', 2, 1),
('2026-09-30', 2, 1),
('2026-09-21', 3, 1),
('2026-09-24', 3, 1),
('2026-09-26', 3, 1),
('2026-09-28', 3, 1),
('2026-09-29', 3, 1),
('2026-09-30', 3, 1),
('2026-12-15', 4, 2),
('2026-12-17', 4, 2),
('2026-12-19', 4, 2),
('2026-12-22', 4, 2),
('2026-12-27', 4, 2),
('2027-01-03', 4, 2),
('2026-12-16', 5, 2),
('2026-12-18', 5, 2),
('2026-12-21', 5, 2),
('2026-12-24', 5, 2),
('2026-12-29', 5, 2),
('2027-01-06', 5, 2),
('2026-04-01', 6, 3),
('2026-04-02', 6, 3),
('2026-04-04', 6, 3),
('2026-04-06', 6, 3),
('2026-04-08', 6, 3),
('2026-04-10', 6, 3);

-- --------------------------------------
-- ITEM_PEDIDO
-- --------------------------------------
INSERT INTO item_pedido (cantidad, id_plato, id_pedido) VALUES
(2, 1, 1), (1, 2, 1),
(1, 3, 2), (2, 4, 2),
(3, 1, 3), (1, 3, 3),
(2, 2, 4), (1, 4, 4),
(1, 1, 5), (2, 4, 5),
(2, 2, 6), (1, 3, 6),
(2, 5, 7), (1, 6, 7),
(1, 7, 8), (2, 8, 8),
(3, 5, 9), (1, 7, 9),
(2, 6, 10), (1, 8, 10),
(1, 5, 11), (2, 8, 11),
(2, 6, 12), (1, 7, 12),
(2, 9, 13), (1, 10, 13),
(1, 11, 14), (2, 12, 14),
(3, 9, 15), (1, 11, 15),
(2, 10, 16), (1, 12, 16),
(1, 9, 17), (2, 12, 17),
(2, 10, 18), (1, 11, 18),
(2, 13, 19), (1, 14, 19),
(1, 15, 20), (2, 16, 20),
(3, 13, 21), (1, 15, 21),
(2, 14, 22), (1, 16, 22),
(1, 13, 23), (2, 16, 23),
(2, 14, 24), (1, 15, 24),
(2, 17, 25), (1, 18, 25),
(1, 19, 26), (2, 20, 26),
(3, 17, 27), (1, 19, 27),
(2, 18, 28), (1, 20, 28),
(1, 17, 29), (2, 20, 29),
(2, 18, 30), (1, 19, 30),
(2, 21, 31), (1, 22, 31),
(1, 23, 32), (2, 24, 32),
(3, 21, 33), (1, 23, 33),
(2, 22, 34), (1, 24, 34),
(1, 21, 35), (2, 24, 35),
(2, 22, 36), (1, 23, 36);