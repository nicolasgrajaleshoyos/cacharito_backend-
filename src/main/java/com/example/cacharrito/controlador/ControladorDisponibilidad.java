package com.example.cacharrito.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cacharrito.modelo.Automoviles;
import com.example.cacharrito.modelo.Disponibilidad;
import com.example.cacharrito.repositorio.RepositorioAutomoviles;
import com.example.cacharrito.repositorio.RepositorioDisponibilidad;

@RestController
@RequestMapping("/api/disponibilidad")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorDisponibilidad {
	  @Autowired
	  private RepositorioDisponibilidad repositorio;
	  
	  private RepositorioAutomoviles repositorioAutomiviles;
	  @GetMapping("/ver_todos")
	  public List<Disponibilidad> verTodasDisponibilidad(){
		  return repositorio.findAll();
	  }
	  
	  @GetMapping("/buscarId")
	  public Optional<Disponibilidad> verDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
		  return repositorio.findById(disponibilidad.getId_disponibilidad());
	  }
	  
	  
	  @PostMapping("/guardar")
	  public Disponibilidad guardarDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
		  Automoviles automovil = repositorioAutomiviles.findById(disponibilidad.getAutomovil().getNumero_de_automovil()).get();
		  Disponibilidad disponibilidad2 = new Disponibilidad(automovil,disponibilidad.getValor_a_pagar(),disponibilidad.getPuestos_disponibles());
		  return repositorio.save(disponibilidad2);
		  
	  }
	  
	  
	  @DeleteMapping("/borrar")
	  public  ResponseEntity<String> borrarDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
	      try {
	          repositorio.deleteById(disponibilidad.getId_disponibilidad());
	          return ResponseEntity.ok("Disponibilidad eliminada correctamente");
	      } catch (Exception e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la Disponibilidad: " + e.getMessage());
	      }
	  }
     
	  @PutMapping("/actualizar")
	  public ResponseEntity<String> actualizarDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
	      return repositorio.findById(disponibilidad.getId_disponibilidad())
	          .map(disponible -> {
	              long nuevosPuestos = disponible.getPuestos_disponibles() - 1;
	              if (nuevosPuestos >= 0) {
	                  disponible.setPuestos_disponibles(nuevosPuestos);
	                  repositorio.save(disponible);
	                  return ResponseEntity.ok("Disponibilidad actualizada correctamente");
	              } else {
	                  return ResponseEntity.badRequest().body("No hay suficientes puestos disponibles");
	              }
	          })
	          .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("La disponibilidad no existe"));
	  }
	   

}
