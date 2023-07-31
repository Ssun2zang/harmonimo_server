package marimo.harmonimo.service;

import marimo.harmonimo.domain.Disease;
import marimo.harmonimo.domain.DiseaseUser;
import marimo.harmonimo.domain.User;
import marimo.harmonimo.dto.User.UserRegisterDTO;
import marimo.harmonimo.repository.DiseaseRepository;
import marimo.harmonimo.repository.DiseaseUserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DiseaseService {
    private final DiseaseRepository diseaseRepository;
    private final DiseaseUserRepository diseaseUserRepository;

    public DiseaseService(DiseaseRepository diseaseRepository, DiseaseUserRepository diseaseUserRepository) {
        this.diseaseRepository = diseaseRepository;
        this.diseaseUserRepository = diseaseUserRepository;
    }

    public List<Disease> GetDiseases(){
        return diseaseRepository.findAll();
    }
    public List<DiseaseUser> GetDiseaseUsers(){
        return diseaseUserRepository.findAll();
    }

    public void SetRelations(User userEntity, List<Long> diseaseIds) {
        List<Disease> diseases = diseaseRepository.findAllById(diseaseIds);
        if (diseases != null) {
            for (Disease disease : diseases) {
                DiseaseUser diseaseUserEntity = new DiseaseUser();
                diseaseUserEntity.setUser(userEntity);
                diseaseUserEntity.setDisease(disease);
                diseaseUserRepository.save(diseaseUserEntity);
            }
        }
    }
}
