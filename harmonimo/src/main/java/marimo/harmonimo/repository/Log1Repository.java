package marimo.harmonimo.repository;

import marimo.harmonimo.domain.Log1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Log1Repository extends JpaRepository<Log1, Long> {

    Optional<Log1> findTopByMarimoUserUserIdOrderByTimestampDesc(Long userId);

    List<Log1> findLog1ByMarimoUserUserId(Long userId);
}
