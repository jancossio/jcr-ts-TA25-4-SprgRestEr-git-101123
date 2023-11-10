package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ISalaDAO;
import com.example.demo.dto.Sala;

@Service
public class SalaServiceImpl implements ISalaService{

	@Autowired
	ISalaDAO iSalaDAO;
		
	@Override
	public List<Sala> listarSalas() {
			
		return iSalaDAO.findAll();
	}

	@Override
	public Sala guardarSala(Sala caja) {
			
		return iSalaDAO.save(caja);
	}

	@Override
	public Sala salaXID(Integer codigo) {
			
		return iSalaDAO.findById(codigo).get();
	}

	@Override
	public Sala actualizarSala(Sala caja) {
			
		return iSalaDAO.save(caja);
	}

	@Override
	public void eliminarSala(Integer codigo) {
		
		iSalaDAO.deleteById(codigo);
			
	}
}
