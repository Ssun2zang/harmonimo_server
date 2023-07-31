package marimo.harmonimo.repository;

import marimo.harmonimo.domain.Disease;
import marimo.harmonimo.domain.DiseaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseUserRepository extends JpaRepository<DiseaseUser, Long> {

}
