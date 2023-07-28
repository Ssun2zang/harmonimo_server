package marimo.harmonimo.service;

import marimo.harmonimo.repository.DiseaseRepository;
import marimo.harmonimo.repository.UserRepository;

import javax.transaction.Transactional;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
