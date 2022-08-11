package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trabajador")//en caso que la tabala sea diferente
public class Trabajador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;
	@Enumerated(EnumType.STRING)
	@Column(name = "trabajo")//no hace falta si se llama igual
	private ResourceType trabajo;
	public enum ResourceType {
		Programador,Dependienta,CEO,Arquitecto
	}
	@Column(name = "salario")
	private Double salario;

	//Constructores 

	public Trabajador(String nombre,ResourceType trabajo) {
		this.nombre = nombre;
		this.setTrabajo(trabajo);
	}

	public Trabajador() {

	}
	
	public double retornaSalario(ResourceType trabajo) {
	        Double salario = 0.0;
	        if (trabajo.name().equalsIgnoreCase(ResourceType.Programador.name())) {
				salario = 20000.00;
			}else if (trabajo.name().equalsIgnoreCase(ResourceType.Dependienta.name())) {
	            salario = 13000.0;
	        }else if (trabajo.name().equalsIgnoreCase(ResourceType.CEO.name())) {
	            salario = 100000.0;
	        }
	        if (trabajo.name().equalsIgnoreCase(ResourceType.Arquitecto.name())) {
	            salario = 25000.0;
	        }
	        return salario;
	}

	//Getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public ResourceType getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(ResourceType trabajo) {
		try {
			this.trabajo = trabajo;
			this.salario = retornaSalario(trabajo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//Método toString

	@Override
	public String toString() {
		return "Trabajador [id=" + id + ", nombre=" + nombre + ", salario=" + salario + ", trabajo=" + trabajo + "]";
	}



}
