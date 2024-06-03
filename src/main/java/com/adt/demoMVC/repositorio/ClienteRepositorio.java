package com.adt.demoMVC.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adt.demoMVC.modelo.Cliente;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Integer> {

    @Query("SELECT c FROM Cliente c WHERE c.cif=:cif")
    List<Cliente> findByCif(String cif);
}


