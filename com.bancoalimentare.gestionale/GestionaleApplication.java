package com.bancoalimentare.gestionale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionaleApplication
{

	public static void main(String[] args)
	{
		// LocalDate dataDistribuzione = LocalDate.now();
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		// String formattedDate = now.format(formatter);
		// LocalDate parsedDate = LocalDate.parse(formattedDate, formatter);

		SpringApplication.run(GestionaleApplication.class, args);

	}

}