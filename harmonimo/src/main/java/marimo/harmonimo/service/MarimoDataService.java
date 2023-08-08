package marimo.harmonimo.service;

import marimo.harmonimo.domain.MarimoData;
import marimo.harmonimo.dto.MarimoData.MarimoDataSensorDTO;
import marimo.harmonimo.repository.MarimoDataRepository;
import marimo.harmonimo.repository.MarimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarimoDataService {
    private final MarimoDataRepository marimoDataRepository;
    private final MarimoRepository marimoRepository;

    public MarimoDataService(MarimoDataRepository marimoDataRepository, MarimoRepository marimoRepository) {
        this.marimoDataRepository = marimoDataRepository;
        this.marimoRepository = marimoRepository;
    }

    public void save(MarimoDataSensorDTO marimoDataSensorDTO) {
        MarimoData marimoData = new MarimoData();
        marimoRepository.findById(marimoDataSensorDTO.getMarimoId())
                .ifPresent(marimo -> marimoData.setMarimo(marimo));
        marimoData.setStat1(marimoDataSensorDTO.getStat1());
        marimoData.setStat2(marimoDataSensorDTO.getStat2());
        marimoData.setStat3(marimoDataSensorDTO.getStat3());
        marimoDataRepository.save(marimoData);
    }

    public List<MarimoData> getMarimoDatas() {
        List<MarimoData> marimoDatas = marimoDataRepository.findAll();
        return marimoDatas;
    }

    public Optional<MarimoData> getMarimoDataByUserId(Long userId) {

        return marimoDataRepository.findTopByMarimoUserUserIdOrderByTimestampDesc(userId);
    }

    public List<MarimoData> getAllMarimoDataByUserId(Long userId) {
        return marimoDataRepository.findAllByMarimoUserUserId(userId);
    }


}
