package marimo.harmonimo.repository;

import marimo.harmonimo.domain.Marimo;
import marimo.harmonimo.domain.MarimoData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MarimoDataRepository extends JpaRepository<MarimoData, Long> {
    Optional<MarimoData> findTopByMarimoUserUserIdOrderByTimestampDesc(Long userId);

    List<MarimoData> findAllByMarimoUserUserId(Long userId);
}
