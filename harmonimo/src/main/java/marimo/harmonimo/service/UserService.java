package marimo.harmonimo.service;

import marimo.harmonimo.domain.User;
import marimo.harmonimo.dto.User.UserDTO;
import marimo.harmonimo.dto.User.UserIdDTO;
import marimo.harmonimo.dto.User.UserLoginDTO;
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
    private final MarimoService marimoService;

    public UserService(UserRepository userRepository, DiseaseService diseaseService, MarimoService marimoService) {
        this.userRepository = userRepository;
        this.diseaseService = diseaseService;
        this.marimoService = marimoService;
    }

    public void save(UserRegisterDTO userRegisterDTO) {

        User userEntity = User.toUserEntity(userRegisterDTO);
        userRepository.save(userEntity);
        Long userId = userEntity.getUserId();

        diseaseService.SetRelations(userEntity, userRegisterDTO.getDiseases());
        marimoService.setMarimoUserRelation(userEntity.getAccountId(), userId);
    }

    public UserIdDTO login(UserLoginDTO user){
        Optional<User> byAccountId = userRepository.findByAccountId(user.getAccountId());
        if(byAccountId.isPresent()){
            User userEntity = byAccountId.get();
            if(userEntity.getPassword().equals(user.getPassword())) {
                UserIdDTO userIdDTO = new UserIdDTO();
                userIdDTO.setUserId(userEntity.getUserId());
                return userIdDTO;
            } else {
                //비밀번호 불일치
                return null;
            }
        } else {
            // 조회 결과가 없다
            return null;
        }
    }

    public boolean checkAccountIdDuplicate(String accountId){
        return userRepository.existsByAccountId(accountId);
    }

    public List<UserDTO> getUsers() { //entity객체는 service에서만
        List<User> users = userRepository.findAll();
        List<UserDTO> dtos = users.stream()
                .map(UserDTO::toUserDTO) // Using method reference
                .collect(Collectors.toList());
        return dtos;
        }
    }
