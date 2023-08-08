package marimo.harmonimo.service;

import marimo.harmonimo.domain.Marimo;
import marimo.harmonimo.domain.User;
import marimo.harmonimo.dto.Marimo.MarimoDTO;
import marimo.harmonimo.dto.User.UserDTO;
import marimo.harmonimo.dto.User.UserIdDTO;
import marimo.harmonimo.repository.MarimoRepository;
import marimo.harmonimo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarimoService {
    private final MarimoRepository marimoRepository;
    private final UserRepository userRepository;

    public MarimoService(MarimoRepository marimoRepository, UserRepository userRepository) {
        this.marimoRepository = marimoRepository;
        this.userRepository = userRepository;
    }

    public Long findMarimoIdByName(String name){
        Optional<Marimo> byName = marimoRepository.findByName(name);
        if(byName.isPresent()){
            Marimo marimo = byName.get();
                if (marimo.getUser() == null) {
                    return marimo.getMarimoId();
                }else{
                    // 이미 마리모 주인이 있음
                    return 0L;
                }
            } else {
                //해당 이름 마리모 없음
                return 0L;
            }
    }

    public void setMarimoUserRelation(String accountID, Long userId){
        Optional<Marimo> byName = marimoRepository.findByName(accountID);
        Optional<User> user = userRepository.findById(userId);
        if(byName.isPresent()&user.isPresent()){
            Marimo marimo = byName.get();
            marimo.setUser(user.get());
            marimoRepository.save(marimo);
            return;
        }else{
            return;
        }
    }

    public Marimo getUserMarimo(Long userId){
        Optional<Marimo> byUserId = marimoRepository.findByUserUserId(userId);
        if(byUserId.isPresent()){
            return byUserId.get();
        }else{
            return null;
        }
    }

    public List<MarimoDTO> getALLMarimo(){
        List<Marimo> marimos = marimoRepository.findAll();
        List<MarimoDTO> dtos = marimos.stream()
                .map(MarimoDTO::ToMarimoDTO) // Using method reference
                .collect(Collectors.toList());
        return dtos;
    }

}
