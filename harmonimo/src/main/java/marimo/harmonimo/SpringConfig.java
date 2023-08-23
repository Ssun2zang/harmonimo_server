package marimo.harmonimo;

import marimo.harmonimo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    private final BoardRepository boardRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository, DiseaseRepository diseaseRepository, DiseaseUserRepository diseaseUserRepository, MarimoDataRepository marimoDataRepository, Log1Repository log1Repository, Log2Repository log2Repository, Log3Repository log3Repository, MarimoRepository marimoRepository, BoardRepository boardRepository) {
        this.userRepository = userRepository;
        this.diseaseRepository = diseaseRepository;
        this.diseaseUserRepository = diseaseUserRepository;
        this.marimoDataRepository = marimoDataRepository;
        this.log1Repository = log1Repository;
        this.log2Repository = log2Repository;
        this.log3Repository = log3Repository;
        this.marimoRepository = marimoRepository;
        this.boardRepository = boardRepository;
    }

    private String uploadDir = System.getProperty("user.home") + "/static/uploadRec"; // 디폴트 경로 설정

    @PostConstruct
    public void init() {
        Path uploadPath = Paths.get(uploadDir);
        try {
            Files.createDirectories(uploadPath);
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory!");
        }
    }
}
