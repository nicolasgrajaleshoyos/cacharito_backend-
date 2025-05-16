package com.example.cacharrito.modelo;


import java.util.Date;
import  java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="reservaciones")
public class Reservaciones {
	public Reservaciones() {
		super();
	}
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id_de_reserva")
   private Long id_de_reserva;
   
   
   
   @ManyToOne()
   @JoinColumn(name="id_disponibilidad")
   private Disponibilidad disponibilidad;
   
   @Column(name="origen")
   private String origen;
   
   @Column(name="destino")
   private String destino;
   
   @Column(name="hora_de_salida")
   private String hora_de_salida;
   
   @Column(name="fecha")
   private LocalDate fecha;
   
   @Column(name="total_a_pagar")
   private Long total_a_pagar;
   
   @Column(name="estado")
   private String estado;
   
public String getOrigen() {
	return origen;
}

public void setOrigen(String origen) {
	this.origen = origen;
}
public Long getId_de_reserva() {
	return id_de_reserva;
}

public void setId_de_reserva(Long id_de_reserva) {
	this.id_de_reserva = id_de_reserva;
}

public String getDestino() {
	return destino;
}

public void setDestino(String destino) {
	this.destino = destino;
}

public String getHora_de_salida() {
	return hora_de_salida;
}

public void setHora_de_salida(String hora_de_salida) {
	this.hora_de_salida = hora_de_salida;
}

public LocalDate getFecha() {
	return fecha;
}

public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}

public Long getTotal_a_pagar() {
	return total_a_pagar;
}

public void setTotal_a_pagar(Long total_a_pagar) {
	this.total_a_pagar = total_a_pagar;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public Disponibilidad getDisponibilidad() {
	return disponibilidad;
}

public void setDisponibilidad(Disponibilidad disponibilidad) {
	this.disponibilidad = disponibilidad;
}

public Reservaciones(Long id_de_reserva, Disponibilidad disponibilidad, String destino,
		String hora_de_salida, LocalDate fecha, Long total_a_pagar, String estado) {
	this.id_de_reserva = id_de_reserva;
	this.disponibilidad = disponibilidad;
	this.destino = destino;
	this.hora_de_salida = hora_de_salida;
	this.fecha = fecha;
	this.total_a_pagar = total_a_pagar;
	this.estado = estado;
}

public Reservaciones(Long id_de_reserva, Disponibilidad disponibilidad, String origen, String destino,
		String hora_de_salida, LocalDate fecha, Long total_a_pagar, String estado) {
	this.id_de_reserva = id_de_reserva;
	this.disponibilidad = disponibilidad;
	this.origen = origen;
	this.destino = destino;
	this.hora_de_salida = hora_de_salida;
	this.fecha = fecha;
	this.total_a_pagar = total_a_pagar;
	this.estado = estado;
}


   
   
   
}
