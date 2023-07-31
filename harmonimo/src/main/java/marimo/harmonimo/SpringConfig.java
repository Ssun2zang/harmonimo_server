package marimo.harmonimo;
import marimo.harmonimo.repository.DiseaseRepository;
import marimo.harmonimo.repository.DiseaseUserRepository;
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

    private final DiseaseUserRepository diseaseUserRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository, DiseaseRepository diseaseRepository, DiseaseUserRepository diseaseUserRepository) {
        this.userRepository = userRepository;
        this.diseaseRepository = diseaseRepository;
        this.diseaseUserRepository = diseaseUserRepository;
    }

}
