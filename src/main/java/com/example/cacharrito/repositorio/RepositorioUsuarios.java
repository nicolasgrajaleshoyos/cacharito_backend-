package com.example.cacharrito.repositorio;


import com.example.cacharrito.modelo.Usuarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuarios,Long> {

    @Query(value="SELECT u.* FROM usuarios u inner JOIN reservaciones r"
    		+ " ON u.id_de_reserva = r.id_de_reserva inner JOIN "
    		+ "disponibilidad d ON r.id_disponibilidad = d.id_disponibilidad "
    		+ "inner JOIN automoviles a ON d.numero_de_automovil = a.numero_de_automovil "
    		+ "WHERE a.numero_de_automovil = :automovilId",nativeQuery=true)
    List<Usuarios> findByUsuariosAutomovilId(@Param("automovilId") Long automovilId);
    
    
}