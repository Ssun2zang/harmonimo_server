package marimo.harmonimo.repository;

import marimo.harmonimo.domain.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {

}
