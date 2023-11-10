package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Pelicula;

public interface IPeliculaService {

	public List<Pelicula> listarPeliculas();
	
	public Pelicula guardarPelicula(Pelicula sala);
	
	public Pelicula peliculaXID(Integer codigo);
	
	public Pelicula actualizarPelicula(Pelicula sala);

	public void eliminarPelicula(Integer codigo);
}
