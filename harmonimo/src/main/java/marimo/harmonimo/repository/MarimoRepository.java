package marimo.harmonimo.repository;

import marimo.harmonimo.domain.Marimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarimoRepository extends JpaRepository<Marimo, Long> {
    Optional<Marimo> findByName(String name);
    Optional<Marimo> findByUserUserId(Long userId);
}
