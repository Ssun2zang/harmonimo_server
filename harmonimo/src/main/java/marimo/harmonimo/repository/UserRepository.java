package marimo.harmonimo.repository;

import marimo.harmonimo.domain.User;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 커스텀 쿼리 메서드들 (필요한 경우 추가 가능)
}

