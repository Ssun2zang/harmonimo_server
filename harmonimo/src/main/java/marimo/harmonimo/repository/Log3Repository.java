package marimo.harmonimo.repository;

import marimo.harmonimo.domain.Log1;
import marimo.harmonimo.domain.Log3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Log3Repository extends JpaRepository<Log3, Long> {

    @Query("SELECT l FROM Log3 l WHERE l.marimo.user.userId = :userId ORDER BY l.timestamp DESC")
    Optional<Log3> findLatestLogByUserId(@Param("userId") Long userId);

    List<Log3> findLog3ByMarimoUserUserId(Long userId);
}
