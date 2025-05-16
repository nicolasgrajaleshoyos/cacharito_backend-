package com.example.cacharrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.cacharrito.modelo.Administrador;
import com.example.cacharrito.servicios.ServicioMiDetallesDeUsuario;

@SpringBootApplication
public class CacharritoBackendApplication implements CommandLineRunner{
	
	@Autowired
	private  ServicioMiDetallesDeUsuario userDetailsService;
	

	
	public static void main(String[] args) {
		SpringApplication.run(CacharritoBackendApplication.class, args);	
	}

	@Override
	public void run(String... args) throws Exception {
		// Descomentar la linia 25 para crear el adminstrador
		//crearAdministrador();
	}

	public void crearAdministrador() {
		  String username = "admin";
	      String password = "1234";

	      Administrador usuario = userDetailsService.crearAdministrador(username, password);
	      System.out.println("Usuario creado: " + usuario.getUsuario());
		
	}



}
