package marimo.harmonimo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "marimo/harmonimo/repository")
public class HarmonimoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarmonimoApplication.class, args);
	}

}
