package com.example.cacharrito.controlador;

import com.example.cacharrito.modelo.Reservaciones;
import com.example.cacharrito.modelo.Usuarios;
import com.example.cacharrito.repositorio.RepositorioReservaciones;
import com.example.cacharrito.repositorio.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins="http://localhost:4200/")
public class ControladorUsuarios {

	@Autowired
	  private RepositorioUsuarios repositorio;
	
	@Autowired
	 private RepositorioReservaciones Reservasrespositorio;
	  
	  @GetMapping("/ver_todos")
	  public List<Usuarios> verTodosLosUsuarrios(){
		  return repositorio.findAll();
	  }
	  
	  @PostMapping("/buscar_id")
	  public List<Reservaciones> verUsuarios(@RequestBody Long id) {
	      return Reservasrespositorio.findBybuscarUsercedula(id);
	  }
	  
	  @PostMapping("/buscarPorIdAutomovil")
	  public List<Usuarios> buscarUsuariosPorIdAutomovil(@RequestBody Long IdAutomovil){
		return repositorio.findByUsuariosAutomovilId(IdAutomovil);
	  }
	  
	  
	  @PostMapping("/guardar")
	  public Usuarios guardarUsuarios(@RequestBody  Usuarios  usuario ) {
		  Reservaciones reserva = Reservasrespositorio.findById(usuario.getReservaciones().getId_de_reserva()).get();
		  Usuarios user = new Usuarios(usuario.getCedula(),reserva,usuario.getNombre(),usuario.getApellido(),usuario.getTelefono(),usuario.getFechaNacimiento());
		  return repositorio.save(user);
		  
	  }
	  
	  @DeleteMapping("/borrar")
	  public  ResponseEntity<String> borrarUsuarios(@RequestBody Usuarios usuario) {
	      try {
	          repositorio.deleteById(usuario.getCedula());
	          return ResponseEntity.ok(" Usuarios eliminados correctamente");
	      } catch (Exception e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario: " + e.getMessage());
	      }
	  }
   
	   @PatchMapping("/actualizar")
	   public ResponseEntity<String> actualizarUsuarios(@RequestBody Usuarios usuarios){
		   try {
		          repositorio.save(usuarios);
		          return ResponseEntity.ok("Usuarios actualizados correctamente");
		      } catch (Exception e) {
		          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar los usuarios : " + e.getMessage());
		      }
		   
	   }
}
