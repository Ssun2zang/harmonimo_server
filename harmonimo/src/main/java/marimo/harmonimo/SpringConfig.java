package marimo.harmonimo;
import marimo.harmonimo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;
    private final DiseaseRepository diseaseRepository;
    private final DiseaseUserRepository diseaseUserRepository;
    private final MarimoDataRepository marimoDataRepository;
    private final Log1Repository log1Repository;
    private final Log2Repository log2Repository;
    private final Log3Repository log3Repository;
    private final MarimoRepository marimoRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository, DiseaseRepository diseaseRepository, DiseaseUserRepository diseaseUserRepository, MarimoDataRepository marimoDataRepository, Log1Repository log1Repository, Log2Repository log2Repository, Log3Repository log3Repository, MarimoRepository marimoRepository) {
        this.userRepository = userRepository;
        this.diseaseRepository = diseaseRepository;
        this.diseaseUserRepository = diseaseUserRepository;
        this.marimoDataRepository = marimoDataRepository;
        this.log1Repository = log1Repository;
        this.log2Repository = log2Repository;
        this.log3Repository = log3Repository;
        this.marimoRepository = marimoRepository;
    }

}
