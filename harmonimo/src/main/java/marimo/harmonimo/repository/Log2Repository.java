package marimo.harmonimo.repository;

import marimo.harmonimo.domain.Log1;
import marimo.harmonimo.domain.Log2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Log2Repository extends JpaRepository<Log2, Long> {

    Optional<Log2> findTopByMarimoUserUserIdOrderByTimestampDesc(Long userId);

    List<Log2> findLog2ByMarimoUserUserId(Long userId);
}
