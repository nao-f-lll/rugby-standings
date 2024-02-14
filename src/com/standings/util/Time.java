package com.standings.util;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Clase utilizada para obtener la fecha y hora actual en un formato específico.
 */
public class Time implements Serializable{
	
	 // declaracion  de variables 
	private static final long serialVersionUID = -8379067663590711231L;
	private static Instant instant; 
	private static LocalDateTime dateTime ;
	private static DateTimeFormatter formatter;
	private static  String formattedDateTime;
	private static  String formattedDate;
	
	/**
	 * Obtiene la hora y fecha actual.
	 * @return La hora y fecha actuales en formato "yyyy-MM-dd HH:mm:ss".
	 */
	public static String getCurrentTime() {
		instant = Instant.ofEpochMilli(System.currentTimeMillis());
		dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		formattedDateTime = dateTime.format(formatter);
		return formattedDateTime;
	}
	
	/**
	 * Obtiene la fecha actual.
	 * @return La fecha actual en formato "yyyy-MM-dd".
	 */
	public static String getDate() {
		instant = Instant.ofEpochMilli(System.currentTimeMillis());
		dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formattedDate = dateTime.format(formatter);
		return formattedDate;
	}
}
