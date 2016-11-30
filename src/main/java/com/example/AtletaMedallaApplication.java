package com.example;

import com.example.Service.AtletaService;
import com.example.Service.MedallaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtletaMedallaApplication {

	private static AtletaService atletaService;
	private static MedallaService medallaService;

	public static void main(String[] args) {
		SpringApplication.run(AtletaMedallaApplication.class, args);
	}
}
