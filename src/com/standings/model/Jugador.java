package com.standings.model;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Jugador {
	
	private String nombre;
	private ArrayList<ImageIcon> fotosPersonales;
	private ArrayList<Team> equipos;
	
	public Jugador(String nombre, ArrayList<ImageIcon> fotosPersonales, ArrayList<Team> equipos) {
		this.nombre = nombre;
		this.fotosPersonales = fotosPersonales;
		this.equipos = equipos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<ImageIcon> getFotoPersonal() {
		return fotosPersonales;
	}

	public void setFotoPersonal(ArrayList<ImageIcon> fotosPersonales) {
		this.fotosPersonales = fotosPersonales;
	}

	public ArrayList<Team> getEquipo() {
		return equipos;
	}

	public void setEquipo(ArrayList<Team> equipos) {
		this.equipos = equipos;
	}
}