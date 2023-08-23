package marimo.harmonimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import marimo.harmonimo.domain.Record;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findAllBySenderUserId(Long userId);
    List<Record> findAllByReceiverUserId(Long userId);
}
