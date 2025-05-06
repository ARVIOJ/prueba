CREATE OR REPLACE FUNCTION obtener_detalle_cliente(cliente_id_param INT)
RETURNS TABLE (
    cliente_id INT,
    nombre VARCHAR,
    correo VARCHAR,
    planeta VARCHAR,
    fecha_registro DATE,
    credito_id INT,
    monto NUMERIC,
    tasa_interes NUMERIC,
    estado VARCHAR,
    fecha_creacion DATE,
    pago_id INT,
    monto_pagado NUMERIC,
    fecha_pago TIMESTAMP
) AS $$
BEGIN
RETURN QUERY
SELECT
    c.id,
    c.nombre,
    c.correo,
    c.planeta,
    c.fecha_registro,
    cr.id,
    cr.monto,
    cr.tasa_interes,
    cr.estado,
    cr.fecha_creacion,
    p.id,
    p.monto_pagado,
    p.fecha_pago
FROM elektra.cliente c
         LEFT JOIN elektra.credito cr ON c.id = cr.cliente_id
         LEFT JOIN elektra.pago p ON cr.id = p.credito_id
WHERE c.id = cliente_id_param;
END;
$$ LANGUAGE plpgsql;
