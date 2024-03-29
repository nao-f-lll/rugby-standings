package com.standings.model;

import javax.swing.ImageIcon;

public class Jugador {
	
	private String nombre;
	private ImageIcon fotoPersonal;
	private Team equipo;
	
	public Jugador(String nombre, ImageIcon fotoPersonal, Team equipo) {
		this.nombre = nombre;
		this.fotoPersonal = fotoPersonal;
		this.equipo = equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ImageIcon getFotoPersonal() {
		return fotoPersonal;
	}

	public void setFotoPersonal(ImageIcon fotoPersonal) {
		this.fotoPersonal = fotoPersonal;
	}

	public Team getEquipo() {
		return equipo;
	}

	public void setEquipo(Team equipo) {
		this.equipo = equipo;
	}
	
	
}