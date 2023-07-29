package marimo.harmonimo.service;

import lombok.RequiredArgsConstructor;
import marimo.harmonimo.domain.User;
import marimo.harmonimo.dto.UserDTO;
import marimo.harmonimo.repository.DiseaseRepository;
import marimo.harmonimo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service //스프링이 관리해주는 객체 == 스프링 빈
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserDTO userDTO) {
        // repsitory의 save 메서드 호출
        User userEntity = User.toUserEntity(userDTO);
        userRepository.save(userEntity);
        //Repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)

    }
}
