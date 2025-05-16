package com.example.cacharrito.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cacharrito.modelo.Automoviles;

@Repository
public interface RepositorioAutomoviles  extends JpaRepository<Automoviles,Long>{
 
}
