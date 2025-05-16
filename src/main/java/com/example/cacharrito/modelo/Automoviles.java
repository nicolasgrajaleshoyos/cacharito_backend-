package com.example.cacharrito.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="automoviles")
public class Automoviles {
	
	public Automoviles() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numero_de_automovil")
	private Long numero_de_automovil;
	
	@Column(name="numero_de_puestos")
	private Long numero_de_puestos;

	public Long getNumero_de_automovil() {
		return numero_de_automovil;
	}

	public void setNumero_de_automovil(Long numero_de_automovil) {
		this.numero_de_automovil = numero_de_automovil;
	}

	public Long getNumero_de_puestos() {
		return numero_de_puestos;
	}

	public void setNumero_de_puestos(Long numero_de_puestos) {
		this.numero_de_puestos = numero_de_puestos;
	}

	public Automoviles(Long numero_de_automovil, Long numero_de_puestos) {
		this.numero_de_automovil = numero_de_automovil;
		this.numero_de_puestos = numero_de_puestos;
	}
	
	

}
