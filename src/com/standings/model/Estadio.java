package com.standings.model;

import java.io.Serializable;

public class Estadio implements Serializable {
	private static final long serialVersionUID = -2364403727577392040L;
	private String nombre;
	
	public Estadio(String nombre) {
		this.nombre = nombre;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String nombre) {
		this.nombre = nombre;
	}
	
	
}
