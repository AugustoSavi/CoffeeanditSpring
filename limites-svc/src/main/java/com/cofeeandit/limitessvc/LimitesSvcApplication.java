package com.cofeeandit.limitessvc;

import com.cofeeandit.limitessvc.LimiteDiario.model.LimiteDiario;
import com.cofeeandit.limitessvc.LimiteDiario.repositories.LimiteDiarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class LimitesSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitesSvcApplication.class, args);
	}

}
