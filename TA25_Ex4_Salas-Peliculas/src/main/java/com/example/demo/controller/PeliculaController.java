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

import com.example.demo.dto.Pelicula;
import com.example.demo.service.PeliculaServiceImpl;

@RestController
@RequestMapping("/api")
public class PeliculaController {

	@Autowired
	PeliculaServiceImpl peliculaServiceImpl;
	
	@GetMapping("/peliculas")
	public List<Pelicula> listarSala(){
		return peliculaServiceImpl.listarPeliculas();
	}
	
	@PostMapping("/peliculas")
	public Pelicula salvarSala(@RequestBody Pelicula pelicula) {
		
		return peliculaServiceImpl.guardarPelicula(pelicula);
	}
	
	@GetMapping("/peliculas/{codigo}")
	public Pelicula salaXID(@PathVariable(name="codigo") Integer codigo) {
		
		Pelicula pelicula_xid= new Pelicula();
		
		pelicula_xid=peliculaServiceImpl.peliculaXID(codigo);
		
		System.out.println("Pelicula XID: "+pelicula_xid);
		
		return pelicula_xid;
	}
	
	@PutMapping("/peliculas/{codigo}")
	public Pelicula actualizarArticulo(@PathVariable(name="codigo")Integer codigo,@RequestBody Pelicula pelicula) {
		
		Pelicula pelicula_seleccionada= new Pelicula();
		Pelicula pelicula_actualizada= new Pelicula();
		
		pelicula_seleccionada= peliculaServiceImpl.peliculaXID(codigo);
		
		pelicula_seleccionada.setNombre(pelicula.getNombre());
		pelicula_seleccionada.setEdad(pelicula.getEdad());

		
		pelicula_actualizada = peliculaServiceImpl.actualizarPelicula(pelicula_seleccionada);
		
		System.out.println("El almacen actualizado es: "+ pelicula_actualizada);
		
		return pelicula_actualizada;
	}
	
	@DeleteMapping("/peliculas/{codigo}")
	public void eliminarDepartamento(@PathVariable(name="codigo") Integer codigo) {
		peliculaServiceImpl.eliminarPelicula(codigo);
	}
}
