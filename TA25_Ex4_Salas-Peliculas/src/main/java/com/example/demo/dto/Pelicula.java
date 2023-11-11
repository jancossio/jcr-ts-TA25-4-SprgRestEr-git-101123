package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pelicula")
public class Pelicula {

	@Id
	@Column(name = "codigo")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "calificacion_Edad")
	private Integer edad;
	
	@OneToMany
    @JoinColumn(name="pelicula")
    private List<Sala> sala;
	
	
	public Pelicula(){
		
	}

	public Pelicula(Integer id, String nombre, Integer edad, List<Sala> sala) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.sala = sala;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Sala")
	public List<Sala> getSala() {
		return sala;
	}

	public void setSala(List<Sala> sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
}
