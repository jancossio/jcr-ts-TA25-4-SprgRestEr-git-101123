package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Pelicula;

public interface IPeliculaService {

	public List<Pelicula> listarPeliculas();
	
	public Pelicula guardarPelicula(Pelicula pelicula);
	
	public Pelicula peliculaXID(Integer id);
	
	public Pelicula actualizarPelicula(Pelicula pelicula);

	public void eliminarPelicula(Integer id);
}
