package marimo.harmonimo.repository;

import marimo.harmonimo.domain.Log1;
import marimo.harmonimo.domain.Log3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Log3Repository extends JpaRepository<Log3, Long> {

    Optional<Log3> findTopByMarimoUserUserIdOrderByTimestampDesc(Long userId);

    List<Log3> findLog3ByMarimoUserUserId(Long userId);
}
