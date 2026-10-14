package com.fromero.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utilerias {
	public static String guardarArchivo(MultipartFile multipart, String ruta) {
		String nombreOriginal = multipart.getOriginalFilename().replace(" ", "-");
		String nombreFinal = randomAlphaNumeric(8) + nombreOriginal;

		try {
			File imageFile = new File(ruta, nombreFinal);
			System.out.println("Archivo: " + imageFile.getAbsolutePath());

			multipart.transferTo(imageFile);

			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Ocurrió un error: " + e);
			return null;
		}
	}
	
	
	// FUNCION ACA BIEN PASADA DE LANZA PARA GENERAR UNA CADENA DE CARACTERES ALEATORIOS!!!
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		
		while(count-- != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}
}
