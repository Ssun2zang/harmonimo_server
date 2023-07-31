package marimo.harmonimo.repository;

import marimo.harmonimo.domain.MarimoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarimoDataRepository extends JpaRepository<MarimoData, Long> {
}
