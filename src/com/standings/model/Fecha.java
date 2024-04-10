package com.standings.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
@Embeddable
public class Fecha implements Comparable<Fecha>,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5402725963046351341L;
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
	// toString
	@Override
	public String toString() {
		return (dia + "/" + mes + "/" + año);
	}
	
	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(año, dia, mes);
	}
	
	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			// si son el mismo objeto
			return true;
		if (obj == null)
			// si obj no esta creado
			return false;
		if (getClass() != obj.getClass())
			// si son de distinta clase
			return false;
		// comparo las propiedades
		Fecha other = (Fecha) obj;
		return (año == other.año && dia == other.dia && mes == other.mes);
	}
	
	// compareTo
	@Override
	public int compareTo(Fecha other) {
		// comparo las propiedades
		int comparacion = 0;
		// comparo año
		if (this.año < other.año) {
			comparacion = -1;
		}
		else if (this.año > other.año) {
			comparacion = 1;
		}
		else {
			// si año es igual
			// comparo mes
			if (this.mes < other.mes) {
				comparacion = -1;
			}
			else if (this.mes > other.mes) {
				comparacion = 1;
			}
			else {
				// si mes es igual
				// comparo dia
				if (this.dia < other.dia) {
					comparacion = -1;
				}
				else if (this.dia > other.dia) {
					comparacion = 1;
				}
			}
		}
		// devuelvo el resultado de la comparacion
		return comparacion;
	}
	
	
	
}

