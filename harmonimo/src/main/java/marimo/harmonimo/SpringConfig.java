package marimo.harmonimo;
import marimo.harmonimo.repository.DiseaseRepository;
import marimo.harmonimo.repository.UserRepository;
import marimo.harmonimo.service.DiseaseService;
import marimo.harmonimo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;
    private final DiseaseRepository diseaseRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository, DiseaseRepository diseaseRepository) {
        this.userRepository = userRepository;
        this.diseaseRepository = diseaseRepository;
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository);
    }

    @Bean
    public DiseaseService diseaseService() {
        return new DiseaseService(diseaseRepository);
    }
}
