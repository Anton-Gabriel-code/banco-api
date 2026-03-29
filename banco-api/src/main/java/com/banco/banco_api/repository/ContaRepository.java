package com.banco.banco_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banco.banco_api.model.Conta;
import org.springframework.stereotype.Repository;


@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
    Conta findByTitular(String titular);
    
}
