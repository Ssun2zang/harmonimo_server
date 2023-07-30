package marimo.harmonimo.service;

import marimo.harmonimo.domain.User;
import marimo.harmonimo.dto.User.UserDTO;
import marimo.harmonimo.dto.User.UserRegisterDTO;
import marimo.harmonimo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //스프링이 관리해주는 객체 == 스프링 빈
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserRegisterDTO userRegisterDTO) {
        User userEntity = User.toUserEntity(userRegisterDTO);
        userRepository.save(userEntity);

    }

    public List<UserDTO> getUsers() { //entity객체는 service에서만
        List<User> users = userRepository.findAll();
        List<UserDTO> dtos = users.stream()
                .map(UserDTO::toUserDTO) // Using method reference
                .collect(Collectors.toList());
        return dtos;
        }
    }
