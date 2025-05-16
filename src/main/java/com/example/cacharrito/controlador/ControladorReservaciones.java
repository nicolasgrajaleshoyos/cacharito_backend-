package com.example.cacharrito.controlador;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cacharrito.modelo.Disponibilidad;
import com.example.cacharrito.modelo.Reservaciones;
import com.example.cacharrito.repositorio.RepositorioDisponibilidad;
import com.example.cacharrito.repositorio.RepositorioReservaciones;



@RestController
@RequestMapping("/api/reservaciones")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorReservaciones {

	  @Autowired
	  private RepositorioReservaciones repositorio;
	  
	  @Autowired
	  private RepositorioDisponibilidad repositorioDisponibilidad;
	  
	  @GetMapping("/ver_todos")
	  public List<Reservaciones> verTodasReservaciones(){
		  return repositorio.findAll();
	  }

	  @GetMapping("/buscar_por_origen_destino_fecha")
	    public ResponseEntity<?> buscarPorOrigenDestinoFecha(
	            @RequestParam("origen") String origen,
	            @RequestParam("destino") String destino,
	            @RequestParam("fecha") String fecha) {
	        // Lógica para buscar reservaciones
		    List<Reservaciones> reservacion = repositorio.findByOrigenAndDestinoAndFecha(origen, destino, fecha);
	        return ResponseEntity.ok(reservacion);
	    }
	  @PostMapping("/buscar")
	  public Optional<Reservaciones> buscarReserva(@RequestBody Long id) {
		  return repositorio.findById(id);
	  }

	  @PostMapping("/buscar_por_dia")
	  public List<Reservaciones> buscarPorDia(@RequestBody Long dia){
		  return repositorio.findBydia(dia);
		  
	  }
	  
	  
	  @PostMapping("/guardar")
	  public Reservaciones guardarReservacion(@RequestBody Reservaciones reservacion ) {
		  Disponibilidad disponibilidad = repositorioDisponibilidad.findById(reservacion.getDisponibilidad().getId_disponibilidad()).get();
		  Reservaciones reservacion1 = new Reservaciones(reservacion.getId_de_reserva(),disponibilidad,reservacion.getOrigen(),reservacion.getDestino(),reservacion.getHora_de_salida(),reservacion.getFecha(),reservacion.getTotal_a_pagar(),reservacion.getEstado());
		  return repositorio.save(reservacion1);
		  
	  }
	  
	  @PutMapping("/actalizar-estado")
	  public void borrarReservacion(@RequestBody Reservaciones reservacion) {
	        Reservaciones reserva = repositorio.findById(reservacion.getId_de_reserva()).get();
	        Reservaciones reserva1 = new Reservaciones(reserva.getId_de_reserva(),reserva.getDisponibilidad(),reserva.getOrigen(),reserva.getDestino(),reserva.getHora_de_salida(),reserva.getFecha(),reserva.getTotal_a_pagar(),reservacion.getEstado());
	        repositorio.save(reserva1);
	  }
     
	   @PatchMapping("/actualizar")
	   public ResponseEntity<String> actualizarReservacion(@RequestBody Reservaciones reservacion){
		   try {
		          repositorio.save(reservacion);
		          return ResponseEntity.ok("Reservación actualizada correctamente");
		      } catch (Exception e) {
		          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la reservación: " + e.getMessage());
		      }
		   
	   }
	   
}
