package com.example.cacharrito.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administrador {
    
        @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_administrador")
	    private Long id_administrador;
	    
	    @Column(name = "usuario")
	    private String usuario;
	    
	    @Column(name = "contraseña")
	    private String contraseña;
	    
	  
	    public Administrador() {
	    	super();
	    }
	    

	
	    // Getters y setters
	    public Long getIdAdministrador() {
	        return id_administrador;
	    }

	    public void setIdAdministrador(Long idAdministrador) {
	        this.id_administrador = idAdministrador;
	    }

	    public String getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(String usuario) {
	        this.usuario = usuario;
	    }

	    public String getContraseña() {
	        return contraseña;
	    }

	    public void setContraseña(String contraseña) {
	        this.contraseña = contraseña;
	    }


		public Administrador(String usuario, String contraseña) {
			this.usuario = usuario;
			this.contraseña = contraseña;
		}
	    
	    
	}