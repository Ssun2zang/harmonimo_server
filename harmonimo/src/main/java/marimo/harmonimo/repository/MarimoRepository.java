package marimo.harmonimo.repository;

import marimo.harmonimo.domain.Marimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarimoRepository extends JpaRepository<Marimo, Long> {
}
