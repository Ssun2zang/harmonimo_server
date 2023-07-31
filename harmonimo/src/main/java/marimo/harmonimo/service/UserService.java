package marimo.harmonimo.service;

import marimo.harmonimo.domain.User;
import marimo.harmonimo.dto.User.UserDTO;
import marimo.harmonimo.dto.User.UserRegisterDTO;
import marimo.harmonimo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //스프링이 관리해주는 객체 == 스프링 빈
public class UserService {
    private final UserRepository userRepository;
    private final DiseaseService diseaseService;

    public UserService(UserRepository userRepository, DiseaseService diseaseService) {
        this.userRepository = userRepository;
        this.diseaseService = diseaseService;
    }

    public void save(UserRegisterDTO userRegisterDTO) {
        User userEntity = User.toUserEntity(userRegisterDTO);
        userRepository.save(userEntity);
        Long userId = userEntity.getUserId();

        diseaseService.SetRelations(userEntity, userRegisterDTO.getDiseases());
    }

//    public UserDTO login(UserDTO memberDTO){ //entity객체는 service에서만
//        Optional<User> byUserEmail = userRepository.findBy(userDTO.getUserEmail());
//        if(byUserEmail.isPresent()){
//            // 조회 결과가 있다
//            UserEntity userEntity = byUserEmail.get(); // Optional에서 꺼냄
//            if(userEntity.getUserPassword().equals(userDTO.getUserPassword())) {
//                //비밀번호 일치
//                //entity -> dto 변환 후 리턴
//                UserDTO dto = UserDTO.toUserDTO(userEntity);
//                return dto;
//            } else {
//                //비밀번호 불일치
//                return null;
//            }
//        } else {
//            // 조회 결과가 없다
//            return null;
//        }
//    }

    public List<UserDTO> getUsers() { //entity객체는 service에서만
        List<User> users = userRepository.findAll();
        List<UserDTO> dtos = users.stream()
                .map(UserDTO::toUserDTO) // Using method reference
                .collect(Collectors.toList());
        return dtos;
        }
    }
