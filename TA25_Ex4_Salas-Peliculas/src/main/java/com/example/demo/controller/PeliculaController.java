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
@RequestMapping("/peliculas")
public class PeliculaController {

	@Autowired
	PeliculaServiceImpl peliculaServiceImpl;
	
	@GetMapping("/all")
	public List<Pelicula> listarPelicula(){
		return peliculaServiceImpl.listarPeliculas();
	}
	
	@PostMapping("/add")
	public Pelicula salvarPelicula(@RequestBody Pelicula pelicula) {
		
		return peliculaServiceImpl.guardarPelicula(pelicula);
	}
	
	@GetMapping("/{id}")
	public Pelicula peliculaXID(@PathVariable(name="id") Integer id) {
		System.out.println("Pelicula XID: +booom");

		Pelicula pelicula_xid= new Pelicula();
		
		pelicula_xid=peliculaServiceImpl.peliculaXID(id);
		
		System.out.println("Pelicula XID: "+pelicula_xid);
		
		return pelicula_xid;
	}
	
	@PutMapping("/{id}")
	public Pelicula actualizarPelicula(@PathVariable(name="id")Integer id,@RequestBody Pelicula pelicula) {
		
		Pelicula pelicula_seleccionada= new Pelicula();
		Pelicula pelicula_actualizada= new Pelicula();
		
		pelicula_seleccionada= peliculaServiceImpl.peliculaXID(id);
		
		pelicula_seleccionada.setNombre(pelicula.getNombre());
		pelicula_seleccionada.setEdad(pelicula.getEdad());

		
		pelicula_actualizada = peliculaServiceImpl.actualizarPelicula(pelicula_seleccionada);
		
		//System.out.println("El almacen actualizado es: "+ pelicula_actualizada);
		
		return pelicula_actualizada;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarPelicula(@PathVariable(name="id") Integer id) {
		peliculaServiceImpl.eliminarPelicula(id);
	}
}
