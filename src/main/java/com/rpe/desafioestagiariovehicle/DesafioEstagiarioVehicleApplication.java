package com.rpe.desafioestagiariovehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioEstagiarioVehicleApplication {

	private static Logger logger = LoggerFactory.getLogger(DesafioEstagiarioVehicleApplication.class);

	public static void main(String[] args) {
		logger.info("Iniciando a API");
		SpringApplication.run(DesafioEstagiarioVehicleApplication.class, args);
		logger.info("API iniciada com sucesso");
	}

}
