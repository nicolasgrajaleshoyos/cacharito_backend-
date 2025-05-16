package com.example.cacharrito.repositorio;

import com.example.cacharrito.modelo.Reservaciones;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioReservaciones extends JpaRepository<Reservaciones, Long> {
	  

	  
	  @Query(value="SELECT * FROM reservaciones WHERE origen = :origen AND destino = :destino AND fecha = :fecha",nativeQuery= true)
	    List<Reservaciones> findByOrigenAndDestinoAndFecha(String origen, String destino, String fecha);
	  
	  @Query(value="SELECT * FROM reservaciones WHERE day(fecha) = :dia",nativeQuery=true)
	  List<Reservaciones> findBydia(@Param("dia") Long dia);
	  

	  @Query(value= "SELECT r.* FROM reservaciones  r \r\n"
	    		+ "inner JOIN usuarios u \r\n"
	    		+ "on r.id_de_reserva = u.id_de_reserva \r\n"
	    		+ "where u.cedula =  :cedulaUsuario",nativeQuery=true)
	    public List<Reservaciones> findBybuscarUsercedula(@Param("cedulaUsuario") Long cedulaUsuario);

}