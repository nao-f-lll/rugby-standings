package com.standings.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Jugador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2498503111687852008L;
	private String nombre;
	private ArrayList<ImageIcon> fotosPersonales;
	private ArrayList<Team> equipos;
	private Nationality nationality;
	private Fecha fechaDeNacemiento;   
	
	public Jugador(String nombre, ImageIcon fotoPersonales, Team equipo, Fecha fechaDeNacemiento, Nationality nationality) {
		this.nombre = nombre;
		fotosPersonales = new ArrayList<>();
		this.fotosPersonales.add(fotoPersonales);
		this.equipos = new ArrayList<>();
		this.equipos.add(equipo);
		this.fechaDeNacemiento = fechaDeNacemiento;
		this.nationality = nationality;
	}
	
	
	public Jugador(Jugador jugador) {
		
		this.nombre = jugador.getNombre();
		fotosPersonales = jugador.getFotosPersonales();
		this.fotosPersonales.add(jugador.getFotosPersonales().get(jugador.getFotosPersonales().size() - 1));
		this.equipos.add(jugador.getEquipo());
		this.fechaDeNacemiento = jugador.getFechaDeNacemiento();
		this.nationality = jugador.getNationality();
	}

	public String getNombre() {
		return nombre;
	}
	
	

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public Fecha getFechaDeNacemiento() {
		return fechaDeNacemiento;
	}

	public void setFechaDeNacemiento(Fecha fechaDeNacemiento) {
		this.fechaDeNacemiento = fechaDeNacemiento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ImageIcon getFotoPersonal() {
		return fotosPersonales.get(fotosPersonales.size() - 1);
	}
	
	public ArrayList<ImageIcon> getFotosPersonales() {
		return fotosPersonales;
	}

	public void setFotoPersonal(ImageIcon fotoPersonales) {
		this.fotosPersonales.add(fotoPersonales);
	}

	public ArrayList<Team> getEquipos() {
		return equipos;
	}
	
	public Team getEquipo() {
		return equipos.get(equipos.size() - 1);
	}

	public void setEquipo(Team equipo) {
		this.equipos.add(equipo);
	}
}