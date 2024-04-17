package com.standings.model;

import java.io.Serializable;

public class Fecha implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 529923849420527344L;

	// Defino la clase Fecha
	// Propiedades o Atributos
	private int dia;
	private int mes;
	private int año;
	// Constructor por defecto
	public Fecha(){
		this.dia = 1;
		this.mes = 1;
		this.año = 2023;
	}
	// Constructor copia
	public Fecha(Fecha f){
		this.dia = f.dia;
		this.mes = f.mes;
		this.año = f.año;	
	}

	// Constructor personalizado
	public Fecha(int d, int m, int a){
		// controlo errores
		if(d >= 1 && d <= 31) {
			this.dia = d;
		}
		if(m >= 1 && m <= 12) {
			this.mes = m;
		}
		if(a != 0) {
			this.año = a;
		}
	}

	// Getters and Setters
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		// controlo errores
		if(dia >= 1 && dia <= 31) {
			this.dia = dia;
		}
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		// controlo errores
		if(mes >= 1 && mes <= 12) {
			this.mes = mes;
		}
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		// controlo errores
		if(año != 0) {
			this.año = año;
		}
	}

}

