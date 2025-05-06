
-- Datos iniciales para cliente
INSERT INTO cliente (nombre, correo, planeta) VALUES
('Luke Skywalker', 'luke@rebels.org', 'Tatooine'),
('Leia Organa', 'leia@rebels.org', 'Alderaan'),
('Darth Vader', 'vader@empire.com', 'Mustafar');

-- Datos iniciales para credito
INSERT INTO credito (cliente_id, monto, tasa_interes, estado) VALUES
(1, 5000.00, 5.0, 'ACTIVO'),
(2, 7000.00, 4.5, 'ACTIVO'),
(3, 10000.00, 6.5, 'VENCIDO');

-- Datos iniciales para pago
INSERT INTO pago (credito_id, monto_pagado) VALUES
(1, 1000.00),
(1, 1500.00),
(2, 3000.00),
(3, 2000.00);


