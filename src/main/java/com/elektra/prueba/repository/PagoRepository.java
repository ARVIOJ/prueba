package com.elektra.prueba.repository;

import com.elektra.prueba.model.Pago;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PagoRepository extends CrudRepository<Pago, Long> {

}
