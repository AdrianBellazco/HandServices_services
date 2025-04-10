-- ========================
-- SERVICIOS
-- ========================
INSERT INTO servicios (id, nombre, descripcion) VALUES (1, 'Plomería', 'Arreglo de tuberías y fugas');
INSERT INTO servicios (id, nombre, descripcion) VALUES (2, 'Electricidad', 'Instalaciones y mantenimiento eléctrico');

-- ========================
-- NIVELES EDUCATIVOS
-- ========================
INSERT INTO niveles_educativos (id, nivel) VALUES (1, 'Bachillerato');
INSERT INTO niveles_educativos (id, nivel) VALUES (2, 'Técnico');
INSERT INTO niveles_educativos (id, nivel) VALUES (3, 'Universitario');

-- ========================
-- USUARIOS
-- ========================
INSERT INTO usuarios (id, nombre, correo, telefono) VALUES (1, 'Carlos Torres', 'carlos@email.com', '3001234567');
INSERT INTO usuarios (id, nombre, correo, telefono) VALUES (2, 'Laura Mendoza', 'laura@email.com', '3009876543');

-- ========================
-- CLIENTES
-- ========================
INSERT INTO cliente (id, usuario_id) VALUES (1, 2);

-- ========================
-- PRESTADORES
-- ========================
INSERT INTO prestador_servicio (id, usuario_id, servicio_id) VALUES (1, 1, 1);

-- ========================
-- COMENTARIOS
-- ========================
INSERT INTO comentarios (id, contenido, autor, fecha, prestador_id) VALUES
    (1, 'Excelente servicio, llegó puntual.', 'Ana Pérez', '2025-04-01', 1);

-- ========================
-- PUNTUACIONES
-- ========================
INSERT INTO puntuaciones (id, valor, comentario, fecha, prestador_id) VALUES
    (1, 5, 'Muy profesional y atento.', '2025-04-01', 1);

-- ========================
-- PETICIONES DE SERVICIO
-- ========================
INSERT INTO peticion_servicio (id, descripcion, estado, fecha, cliente_id, prestador_id) VALUES
    (1, 'Necesito arreglar una fuga en la cocina', 'pendiente', '2025-04-05', 1, 1);

-- ========================
-- RELACIÓN CLIENTE - PRESTADOR (ManyToMany)
-- ========================
INSERT INTO prestador_cliente (prestador_id, cliente_id) VALUES
    (1, 1);

-- ========================
-- RELACIÓN PRESTADOR - NIVEL EDUCATIVO (ManyToMany)
-- ========================
INSERT INTO prestador_nivel_educativo (prestador_id, nivel_educativo_id) VALUES
                                                                             (1, 2), -- Técnico
                                                                             (1, 3); -- Universitario
