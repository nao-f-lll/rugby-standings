package com.standings.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Time {
	
	private static Instant instant; 
	private static LocalDateTime dateTime ;
	private static DateTimeFormatter formatter;
	private static  String formattedDateTime;
	private static  String formattedDate;
	
	public static String getCurrentTime() {
		instant = Instant.ofEpochMilli(System.currentTimeMillis());
		dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		formattedDateTime = dateTime.format(formatter);
		return formattedDateTime;
	}
	
	public static String getDate() {
		instant = Instant.ofEpochMilli(System.currentTimeMillis());
		dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formattedDate = dateTime.format(formatter);
		return formattedDate;
	}
}
