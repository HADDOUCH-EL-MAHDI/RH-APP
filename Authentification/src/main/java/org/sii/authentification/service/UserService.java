package org.sii.authentification.service;

import org.sii.authentification.model.Utilisateur;
import org.sii.authentification.model.Utilisateur;
import org.sii.authentification.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Utilisateur getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
