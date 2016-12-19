package com.example;

import com.example.Service.AtletaService;
import com.example.Service.MedallaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AtletaMedallaApplication {

	private static AtletaService atletaService;
	private static MedallaService medallaService;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AtletaMedallaApplication.class, args);

		atletaService = context.getBean(AtletaService.class);
		medallaService = context.getBean(MedallaService.class);

		atletaService.testAtleta();
		medallaService.testMedalla();
	}
}
