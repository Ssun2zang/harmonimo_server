package marimo.harmonimo.repository;

import marimo.harmonimo.domain.Log1;
import marimo.harmonimo.domain.Log2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Log2Repository extends JpaRepository<Log2, Long> {

    @Query("SELECT l FROM Log2 l WHERE l.marimo.user.userId = :userId ORDER BY l.timestamp DESC")
    Optional<Log2> findLatestLogByUserId(@Param("userId") Long userId);

    List<Log2> findLog2ByMarimoUserUserId(Long userId);
}
