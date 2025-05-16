package com.example.cacharrito.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cacharrito.modelo.Disponibilidad;

@Repository
public interface RepositorioDisponibilidad extends JpaRepository<Disponibilidad,Long>{

}
