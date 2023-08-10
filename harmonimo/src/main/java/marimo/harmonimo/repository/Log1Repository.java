package marimo.harmonimo.repository;

import marimo.harmonimo.domain.Log1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Log1Repository extends JpaRepository<Log1, Long> {

    // 이 쿼리는 Marimo 엔티티의 userId와 관련된 최근 로그를 조회합니다.
    @Query("SELECT l FROM Log1 l WHERE l.marimo.user.userId = :userId ORDER BY l.timestamp DESC")
    Optional<Log1> findLatestLogByUserId(@Param("userId") Long userId);

    List<Log1> findLog1ByMarimoUserUserId(Long userId);
}
