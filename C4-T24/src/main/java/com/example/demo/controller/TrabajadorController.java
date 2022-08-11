package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Trabajador;
import com.example.demo.service.TrabajadorServiceImpl;

@RestController
@RequestMapping("/api")
public class TrabajadorController {

	@Autowired
	TrabajadorServiceImpl trabajadorServideImpl;
	
	@GetMapping("/trabajadores")
	public List<Trabajador> listarTrabajadores(){
		return trabajadorServideImpl.listarTrabajadores();
	}
	
	//listar Trabajadores por campo nombre
	@GetMapping("/trabajadores/nombre/{nombre}")
	public List<Trabajador> listarTrabajadoresNombre(@PathVariable(name="nombre") String nombre) {
	    return trabajadorServideImpl.listarTrabajadorNombre(nombre);
	}
	
	@GetMapping("/trabajadores/trabajo/{trabajo}")
	public List<Trabajador> listarTrabajadoresTrabajo(@PathVariable(name="trabajo") String trabajo) {
	    return trabajadorServideImpl.listarTrabajadorTrabajo(trabajo);
	}
	
	
	@PostMapping("/trabajadores")
	public Trabajador salvarTrabajador(@RequestBody Trabajador trabajador) {
		Trabajador trabajo_id= new Trabajador(trabajador.getNombre(), trabajador.getTrabajo());
		return trabajadorServideImpl.guardarTrabajador(trabajo_id);
	}
	
	
	@GetMapping("/trabajadores/{id}")
	public Trabajador trabajadorXID(@PathVariable(name="id") Long id) {
		
		Trabajador trabajador_xid= new Trabajador();
		
		trabajador_xid=trabajadorServideImpl.trabajadorXID(id);
		
		System.out.println("Trabajador XID: "+trabajador_xid);
		
		return trabajador_xid;
	}
	
	@PutMapping("/trabajadores/{id}")
	public Trabajador actualizarTrabajador(@PathVariable(name="id")Long id,@RequestBody Trabajador trabajador) {
		
		Trabajador trabajador_seleccionado;
		Trabajador trabajador_actualizado;
		
		trabajador_seleccionado= trabajadorServideImpl.trabajadorXID(id);
		
		trabajador_seleccionado.setNombre(trabajador.getNombre());
		trabajador_seleccionado.setTrabajo(trabajador.getTrabajo());
		
		trabajador_actualizado = trabajadorServideImpl.actualizarTrabajador(trabajador_seleccionado);
		
		System.out.println("El trabajador actualizado es: "+ trabajador_actualizado);
		
		return trabajador_actualizado;
	}
	
	@DeleteMapping("/trabajadores/{id}")
	public void eliminarTrabajador(@PathVariable(name="id")Long id) {
		trabajadorServideImpl.eliminarTrabajador(id);
	}
}
