package com.example.demo.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="salas")
public class Sala {

	@Id
	@Column(name = "codigo")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
    @JoinColumn(name="pelicula")
    private Pelicula pelicula;
	
	
	public Sala(){
		
	}

	public Sala(Integer id, String nombre, Pelicula pelicula) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pelicula = pelicula;
	}


	public Integer getCodigo() {
		return id;
	}

	public void setCodigo(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", nombre=" + nombre + ", pelicula=" + pelicula + "]";
	}
}
