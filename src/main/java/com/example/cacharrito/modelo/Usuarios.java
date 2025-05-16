package com.example.cacharrito.modelo;


import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@ Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @Column(name = "cedula")
    private long cedula;
    
   //@OneToOne(mappedBy= "id_de_reserva")
    //private Reservaciones reservaciones;

    @ManyToOne
    @JoinColumn(name = "id_de_reserva")
    private Reservaciones reservaciones;


	public Reservaciones getReservaciones() {
		return reservaciones;
	}


	public void setReservaciones(Reservaciones reservaciones) {
		this.reservaciones = reservaciones;
	}

	@Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "telefeno")
    private Long telefono;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    // Constructor, getters y setters

    public Usuarios() {}

   


	// Getters y setters

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getTelefono() {
        return telefono;
    }

    

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}


	public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


	public Usuarios(long cedula, Reservaciones reservaciones, String nombre, String apellido, Long telefono,
			Date fechaNacimiento) {
		this.cedula = cedula;
		this.reservaciones = reservaciones;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}


    
    
}
