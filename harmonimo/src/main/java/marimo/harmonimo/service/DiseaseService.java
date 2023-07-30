package marimo.harmonimo.service;

import marimo.harmonimo.domain.Disease;
import marimo.harmonimo.repository.DiseaseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DiseaseService {
    private final DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    public List<Disease> GetDiseases(){
        return diseaseRepository.findAll();
    }
}
