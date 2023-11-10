package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Sala;

public interface ISalaService {

	public List<Sala> listarSalas();
	
	public Sala guardarSala(Sala sala);
	
	public Sala salaXID(Integer codigo);
	
	public Sala actualizarSala(Sala sala);

	public void eliminarSala(Integer codigo);
}
