package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPeliculaDAO;
import com.example.demo.dto.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculaService{

	@Autowired
	IPeliculaDAO iPeliculaDAO;
		
	@Override
	public List<Pelicula> listarPeliculas() {
			
		return iPeliculaDAO.findAll();
	}

	@Override
	public Pelicula guardarPelicula(Pelicula caja) {
			
		return iPeliculaDAO.save(caja);
	}

	@Override
	public Pelicula peliculaXID(Integer codigo) {
			
		return iPeliculaDAO.findById(codigo).get();
	}

	@Override
	public Pelicula actualizarPelicula(Pelicula caja) {
			
		return iPeliculaDAO.save(caja);
	}

	@Override
	public void eliminarPelicula(Integer codigo) {
		
		iPeliculaDAO.deleteById(codigo);
			
	}
}
