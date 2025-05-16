package com.example.cacharrito.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="disponibilidad")
public class Disponibilidad {
	
	public Disponibilidad() {
		super();
	}
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id_disponibilidad")
  private Long id_disponibilidad;
  
  
  @OneToOne()
  @JoinColumn(name = "numero_de_automovil")
  private Automoviles automovil;
  
  @Column(name="valor_a_pagar")
  private Long valor_a_pagar;
  
  @Column(name="puestos_disponibles")
  private Long puestos_disponibles;


public Long getId_disponibilidad() {
	return id_disponibilidad;
}

public void setId_disponibilidad(Long id_disponibilidad) {
	this.id_disponibilidad = id_disponibilidad;
}

public Automoviles getAutomovil() {
	return automovil;
}

public void setAutomovil(Automoviles automovil) {
	this.automovil = automovil;
}

public Long getValor_a_pagar() {
	return valor_a_pagar;
}

public void setValor_a_pagar(Long valor_a_pagar) {
	this.valor_a_pagar = valor_a_pagar;
}

public Long getPuestos_disponibles() {
	return puestos_disponibles;
}

public void setPuestos_disponibles(Long puestos_disponibles) {
	this.puestos_disponibles = puestos_disponibles;
}

public Disponibilidad( Automoviles automovil, Long valor_a_pagar, Long puestos_disponibles) {
	this.automovil = automovil;
	this.valor_a_pagar = valor_a_pagar;
	this.puestos_disponibles = puestos_disponibles;
}


  
}
