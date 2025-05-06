package com.elektra.prueba.repository;

import com.elektra.prueba.model.Credito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditoRepository extends CrudRepository<Credito, Long> {

}
