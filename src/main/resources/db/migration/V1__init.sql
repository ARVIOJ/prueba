-- Crear esquema si no existe
CREATE SCHEMA IF NOT EXISTS elektra;

-- Usar esquema
SET search_path TO elektra;

CREATE TABLE cliente (
                         id SERIAL PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         correo VARCHAR(100) UNIQUE NOT NULL,
                         planeta VARCHAR(100),
                         fecha_registro DATE DEFAULT CURRENT_DATE
);

CREATE TABLE credito (
                         id SERIAL PRIMARY KEY,
                         cliente_id INTEGER NOT NULL REFERENCES cliente(id) ON DELETE CASCADE,
                         monto NUMERIC(12, 2) NOT NULL,
                         tasa_interes NUMERIC(5, 2) NOT NULL,
                         estado VARCHAR(20) DEFAULT 'PENDIENTE',
                         fecha_creacion DATE DEFAULT CURRENT_DATE
);

CREATE TABLE pago (
                      id SERIAL PRIMARY KEY,
                      credito_id INTEGER NOT NULL REFERENCES credito(id) ON DELETE CASCADE,
                      monto_pagado NUMERIC(12, 2) NOT NULL,
                      fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE OR REPLACE FUNCTION total_pagado(credito_id_param INT)
RETURNS NUMERIC AS $$
DECLARE
total NUMERIC;
BEGIN
SELECT SUM(monto_pagado) INTO total
FROM pago
WHERE credito_id = credito_id_param;

RETURN COALESCE(total, 0);
END;
$$ LANGUAGE plpgsql;
