package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Trabajador;

public interface ITrabajadorService {
	
	//Metodos del CRUD
		public List<Trabajador> listarTrabajadores(); //Listar All 
		
		public Trabajador guardarTrabajador(Trabajador trabajador);	//Guarda un cliente CREATE
		
		public Trabajador trabajadorXID(Long id); //Leer datos de un cliente READ
		
		public List<Trabajador> listarTrabajadorNombre(String nombre);//Listar Clientes por campo nombre
		
		public Trabajador actualizarTrabajador(Trabajador trabajador); //Actualiza datos del cliente UPDATE
		
		public void eliminarTrabajador(Long id);// Elimina el cliente DELETE

		public List<Trabajador> listarTrabajadorTrabajo(String trabajo);

}
