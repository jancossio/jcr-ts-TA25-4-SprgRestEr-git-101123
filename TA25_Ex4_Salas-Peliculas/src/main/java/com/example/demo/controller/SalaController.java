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

import com.example.demo.dto.Sala;
import com.example.demo.service.SalaServiceImpl;

@RestController
@RequestMapping("/salas")
public class SalaController {

	@Autowired
	SalaServiceImpl salaServiceImpl;
	
	@GetMapping("/all")
	public List<Sala> listarSala(){
		return salaServiceImpl.listarSalas();
	}
	
	@PostMapping("/add")
	public Sala salvarSala(@RequestBody Sala sala) {
		
		return salaServiceImpl.guardarSala(sala);
	}
	
	@GetMapping("/{id}")
	public Sala salaXID(@PathVariable(name="id") Integer id) {
		
		Sala sala_xid= new Sala();
		
		sala_xid=salaServiceImpl.salaXID(id);
		
		//System.out.println("Sala XID: "+sala_xid);
		
		return sala_xid;
	}
	
	@PutMapping("/{id}")
	public Sala actualizarSala(@PathVariable(name="id")Integer id,@RequestBody Sala sala) {
		
		Sala sala_seleccionada= new Sala();
		Sala sala_actualizada= new Sala();
		
		sala_seleccionada= salaServiceImpl.salaXID(id);
		
		sala_seleccionada.setNombre(sala.getNombre());
		sala_seleccionada.setPelicula(sala.getPelicula());

		
		sala_actualizada = salaServiceImpl.actualizarSala(sala_seleccionada);
		
		System.out.println("El almacen actualizado es: "+ sala_actualizada);
		
		return sala_actualizada;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarSala(@PathVariable(name="id") Integer id) {
		salaServiceImpl.eliminarSala(id);
	}
}
